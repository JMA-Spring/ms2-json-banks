package com.ms2.banco;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ms2.banco.controllers.bancoController;
import com.ms2.banco.domain.Banco;
import com.ms2.banco.domain.Consulta;
import com.ms2.banco.services.ObtenerBancoService;

@RunWith(SpringRunner.class)
@WebMvcTest(bancoController.class)
public class BancoControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ObtenerBancoService bancoService;
	
	
	
	@Test
	public void ControllerTestBasic() throws Exception {
	
		Banco banco = new Banco();
		List<Banco> list = new ArrayList<>();
		list.add(banco);
		Consulta consulta = new Consulta();
		
		consulta.setBancos(list);
		
		when(bancoService.getBancos(consulta)).thenReturn(consulta);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/bancos")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andReturn();
		
	}
	

}
