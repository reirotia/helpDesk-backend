package com.reinaldo.helpDesk.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.reinaldo.helpDesk.domain.Tecnico;
import com.reinaldo.helpDesk.domain.dto.TecnicoDTO;
import com.reinaldo.helpDesk.services.TecnicoService;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {

	@Autowired
	private TecnicoService tecnicoService;

	@GetMapping("/{id}")
	public ResponseEntity<TecnicoDTO> buscarPorId(@PathVariable Integer id) {
		Tecnico obj = this.tecnicoService.buscarPorId(id);
		return ResponseEntity.ok().body(new TecnicoDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<TecnicoDTO>> listaTodos() {
		 List<Tecnico> lista = this.tecnicoService.listarTodos();
		 List<TecnicoDTO> listaDTO = lista.stream().map(x -> new TecnicoDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	@PostMapping
	public ResponseEntity<TecnicoDTO> salvar(@RequestBody TecnicoDTO objDTO){
		
		Tecnico obj = tecnicoService.salvar(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
