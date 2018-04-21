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
import com.ms2.banco.domain.Consulta;

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
			File file = new File("C:\\Users\\JesusMonroyAngeles\\Documents\\Ejercicio Banco\\bancos.json");
			Scanner sc = new Scanner(file);

			while (sc.hasNextLine()) {
				bank = mapper.readValue(sc.nextLine(), Banco.class);
				bancos.add(bank);
			}
			System.err.println("Lista de Bancos cargada");
			sc.close();

		} catch (JsonParseException e) {
			System.err.println(e.getMessage());
		} catch (JsonMappingException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	@Override
	public List<Banco> getBancosGPS(Double[] gps) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Banco> getBancosPostal(String zipcode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Banco> getBancosEstado(String estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Banco> getBancosDelegacion(String delegacion) {
		// TODO Auto-generated method stub
		return null;
	}

}
