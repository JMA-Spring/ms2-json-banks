package com.ms2.banco;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ms2.banco.domain.Banco;
import com.ms2.banco.model.BancoDAOImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BancoDAOTest {
	
	private BancoDAOImpl banco = new BancoDAOImpl();
	private List<Banco> nearBanks;
	
	@Before
	public void init() {
		nearBanks = new ArrayList<>();
	}
	
	
	@Test
	public void getBancosGPSTestOutOfRange() {
		nearBanks = banco.getBancosGPS(new Double[] {new Double(-99.217711),new Double(19.371755)});
		assertNotNull(nearBanks);
	}
	
	@Test
	public void getBancosGPSTestInRange() {
		nearBanks = banco.getBancosGPS(new Double[] {new Double(23.344),new Double(54555.3434)});
		assertNotNull(nearBanks);
	}
	
	@Test
	public void getBancosPostalTest() {
		nearBanks = banco.getBancosPostal("52929");
		assertNotNull(nearBanks);
	}
	
	@Test
	public void getBancosEstadoTest() {
		nearBanks = banco.getBancosEstado("jalisco");
		assertNotNull(nearBanks);
	}

	@Test
	public void getBancosDelegacioTest() {
		nearBanks = banco.getBancosDelegacion("metepec");
		assertNotNull(nearBanks);
	}

	
	
}
