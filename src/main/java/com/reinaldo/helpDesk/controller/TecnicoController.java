package com.reinaldo.helpDesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reinaldo.helpDesk.domain.Tecnico;
import com.reinaldo.helpDesk.services.TecnicoService;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {

	@Autowired
	private TecnicoService tecnicoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Tecnico> buscarPorId(@PathVariable Integer id){
		Tecnico obj = this.tecnicoService.buscarPorId(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
