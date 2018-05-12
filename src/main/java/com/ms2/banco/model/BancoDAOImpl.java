package com.ms2.banco.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Repository;

import com.ms2.banco.domain.Banco;

import static org.springframework.util.ResourceUtils.getFile;

@Repository
public class BancoDAOImpl implements BancoDAO {
	
	List<Banco> bancos = new ArrayList<>();
	Banco bank;
	
	public BancoDAOImpl () {
		loadBancos();
	}

	private void loadBancos() {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			File file = new File("C:\\Users\\Jesus Monroy\\Dropbox\\IBM\\Spring-Course\\ms2-json-banks\\src\\main\\resources\\bancos.json");
			Scanner sc = new Scanner(file);
			
			while (sc.hasNextLine()) {
				bank = mapper.readValue(sc.nextLine(), Banco.class);
				bancos.add(bank);
			}
			System.out.println("Lista de Bancos cargada");
			sc.close();

		} catch (JsonParseException e) {
			System.err.println(e.getMessage());
		} catch (JsonMappingException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	private boolean inRange(Double[] c1, Double[] c2) {
		Double distance = Math.sqrt(Math.pow(c1[0]-c2[0],2) + Math.pow(c1[1]-c2[1],2));
		if (distance <= 0.0225)	
			return true;
		return false;
	}
	
	private boolean isSucursalATM(Integer tipo) {
		if (tipo != 500 && tipo != 600)
			return true;
		return false;
		
	}
	
	@Override
	public List<Banco> getBancosGPS(Double[] gps) {
		List<Banco> nearBanks = new ArrayList<>();
		for(Banco bank: bancos) {
			if(inRange(bank.getGeometry().getCoordinates(),gps) && isSucursalATM(bank.getPropiedades().getTipo_sucursal()))
				nearBanks.add(bank);
		}
		return nearBanks;
	}


	@Override
	public List<Banco> getBancosPostal(String zipcode) {
		List<Banco> nearBanks = new ArrayList<>();
		String dir[];
		for(Banco bank: bancos) {
			dir = bank.getPropiedades().getDireccion2().split(",");
			for (String s: dir) {
				if (s.contains("C.P. "))
					if(s.replace(" ","").substring(4).equals(zipcode) && isSucursalATM(bank.getPropiedades().getTipo_sucursal()))
						nearBanks.add(bank);
			}
		}
		return nearBanks;
	}

	@Override
	public List<Banco> getBancosEstado(String estado) {
		List<Banco> nearBanks = new ArrayList<>();
		String dir;
		for(Banco bank: bancos) {
			dir = bank.getPropiedades().getEstado();
			if(dir.replace(" ", "").toLowerCase().equals(estado.toLowerCase().replace(" ", "")) && isSucursalATM(bank.getPropiedades().getTipo_sucursal()))
				nearBanks.add(bank);
		}
		return nearBanks;
	}

	@Override
	public List<Banco> getBancosDelegacion(String delegacion) {
		List<Banco> nearBanks = new ArrayList<>();
		String dir[];
		for(Banco bank: bancos) {
			dir = bank.getPropiedades().getDireccion2().split(",");
			if(dir[1].replace(" ", "").toLowerCase().equals(delegacion.toLowerCase().replace(" ", "")) && isSucursalATM(bank.getPropiedades().getTipo_sucursal()))
				nearBanks.add(bank);
		}
		return nearBanks;
	}

}
