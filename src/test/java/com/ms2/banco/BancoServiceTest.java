package com.ms2.banco;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ms2.banco.domain.Banco;
import com.ms2.banco.domain.Consulta;
import com.ms2.banco.model.BancoDAO;
import com.ms2.banco.services.ObtenerBancoserviceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BancoServiceTest {
	
	@Mock
	BancoDAO bancoDAO;
	
	@InjectMocks
	ObtenerBancoserviceImpl service;

	private Banco banco;
	private List<Banco> list;
	private Double[] gps;
	private Consulta consulta;
	
	
	@Before
	public void init() {
		//MockitoAnnotations.initMocks(this);
		banco = new Banco();
		list = new ArrayList<>();
		gps = new Double[] {new Double(23.344),new Double(54555.3434)};
		consulta = new Consulta();
		consulta.setCoordinates(gps);
		consulta.setZipCode("52929");
		consulta.setDelegacion("metepec");
		consulta.setEstado("jalisco");
		list.add(banco);
	}
	
	@Test
	public void getBancosCoordenadasCaseTest() {		
		when(bancoDAO.getBancosGPS(consulta.getCoordinates())).thenReturn(list);
		service.getBancos(consulta);
		assertNotNull(consulta.getBancos());
	}
	
	@Test
	public void getBancosZipcodeCaseTest() {
		gps[0] = null;
		gps[1] = null;
		consulta.setCoordinates(gps);
		when(bancoDAO.getBancosPostal(consulta.getZipCode())).thenReturn(list);
		service.getBancos(consulta);
		assertNotNull(consulta.getBancos());
	}
	
	@Test
	public void getBancosZipcodeCaseTestWithGPSNotNull() {
		gps[0] = null;
		consulta.setCoordinates(gps);
		when(bancoDAO.getBancosPostal(consulta.getZipCode())).thenReturn(list);
		service.getBancos(consulta);
		assertNotNull(consulta.getBancos());
	}
	
	@Test
	public void getBancosZipcodeCaseTestWithGPSNotNull2() {
		gps[1] = null;
		consulta.setCoordinates(gps);
		when(bancoDAO.getBancosPostal(consulta.getZipCode())).thenReturn(list);
		service.getBancos(consulta);
		assertNotNull(consulta.getBancos());
	}
	
	
	@Test
	public void getBancosDelegacionCaseTest() {
		gps[0] = null;
		gps[1] = null;
		consulta.setCoordinates(gps);
		consulta.setZipCode("");
		when(bancoDAO.getBancosDelegacion(consulta.getDelegacion())).thenReturn(list);
		service.getBancos(consulta);
		assertNotNull(consulta.getBancos());
	}
	
	@Test
	public void getBancosDelegacionCaseTestWithZipNull() {
		gps[0] = null;
		gps[1] = null;
		consulta.setCoordinates(gps);
		consulta.setZipCode(null);
		when(bancoDAO.getBancosDelegacion(consulta.getDelegacion())).thenReturn(list);
		service.getBancos(consulta);
		assertNotNull(consulta.getBancos());
	}
	
	@Test
	public void getBancosEstadoCaseTest() {
		gps[0] = null;
		gps[1] = null;
		consulta.setCoordinates(gps);
		consulta.setZipCode("");
		consulta.setDelegacion("");
		when(bancoDAO.getBancosEstado(consulta.getEstado())).thenReturn(list);
		service.getBancos(consulta);
		assertNotNull(consulta.getBancos());
	}
	
	@Test
	public void getBancosEstadoCaseTestWithDelNull() {
		gps[0] = null;
		gps[1] = null;
		consulta.setCoordinates(gps);
		consulta.setZipCode("");
		consulta.setDelegacion(null);
		when(bancoDAO.getBancosEstado(consulta.getEstado())).thenReturn(list);
		service.getBancos(consulta);
		assertNotNull(consulta.getBancos());
	}
	
	@Test
	public void getBancosNull() {
		gps[0] = null;
		gps[1] = null;
		consulta.setCoordinates(gps);
		consulta.setZipCode("");
		consulta.setDelegacion("");
		consulta.setEstado("");
		when(bancoDAO.getBancosEstado(consulta.getEstado())).thenReturn(null);
		service.getBancos(consulta);
		assertNull(consulta.getBancos());
	}
	
	@Test
	public void getBancosNull2() {
		gps[0] = null;
		gps[1] = null;
		consulta.setCoordinates(gps);
		consulta.setZipCode("");
		consulta.setDelegacion("");
		consulta.setEstado(null);
		when(bancoDAO.getBancosEstado(consulta.getEstado())).thenReturn(null);
		service.getBancos(consulta);
		assertNull(consulta.getBancos());
	}

	
	
	
	

}
