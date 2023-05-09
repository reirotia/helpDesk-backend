package com.reinaldo.helpDesk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reinaldo.helpDesk.domain.Tecnico;
import com.reinaldo.helpDesk.repository.TecnicoRepository;
import com.reinaldo.helpDesk.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository tecnicoRepo;

	public Tecnico buscarPorId(Integer id) {
		return  this.tecnicoRepo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado " + id));
	}
	
	public List<Tecnico> listarTodos() {
		return tecnicoRepo.findAll();
	}
}
