package com.ms2.banco.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ms2.banco.domain.Consulta;
import com.ms2.banco.services.ObtenerBancoService;


@RestController
public class bancoController {
	
	@Autowired
	private ObtenerBancoService bancoService;
	
	

	@RequestMapping(path = "/bancos", method = RequestMethod.GET)
	public Consulta getBanks(@Valid Consulta consult){
		return bancoService.getBancos(consult);
	}
		 
}