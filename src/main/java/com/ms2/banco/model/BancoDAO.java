package com.ms2.banco.model;

import java.util.List;

import com.ms2.banco.domain.Banco;
import com.ms2.banco.domain.Consulta;

public interface BancoDAO {
	public List<Banco> getBancosGPS(Double[] gps);
	public List<Banco> getBancosPostal(String zipcode);
	public List<Banco> getBancosEstado(String estado);
	public List<Banco> getBancosDelegacion(String delegacion);

}
