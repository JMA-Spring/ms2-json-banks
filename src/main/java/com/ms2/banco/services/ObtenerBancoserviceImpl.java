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
		if(consulta.getCoordinates()[0] != null && consulta.getCoordinates()[1] != null)
			consulta.setBancos(bancos.getBancosGPS(consulta.getCoordinates()));
		else if(consulta.getZipCode() != null && !consulta.getZipCode().equals(""))
			consulta.setBancos(bancos.getBancosPostal(consulta.getZipCode()));
		else if (consulta.getDelegacion() != null && !consulta.getDelegacion().equals(""))
			consulta.setBancos(bancos.getBancosDelegacion(consulta.getDelegacion()));
		else if (consulta.getEstado() != null && !consulta.getEstado().equals(""))
			consulta.setBancos(bancos.getBancosEstado(consulta.getEstado()));
		
		return consulta;
	}
	
	

}
