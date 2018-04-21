package com.ms2.banco.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ms2.banco.domain.Consulta;
import com.ms2.banco.model.BancoDAO;

@Service
public class ObtenerBancoserviceImpl implements ObtenerBancoService{

	@Autowired
	private BancoDAO bancos;
	
	@Override
	public Consulta getBancos(Consulta consulta) {
		consulta.setBancos(bancos.getBancosGPS(consulta.getCoordinates()));
		return consulta;
	}
	
	

}
