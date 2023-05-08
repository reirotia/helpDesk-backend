package com.reinaldo.helpDesk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reinaldo.helpDesk.domain.Tecnico;
import com.reinaldo.helpDesk.repository.TecnicoRepository;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository tecnicoRepo;

	public Tecnico buscarPorId(Integer id) {
		return  this.tecnicoRepo.findById(id).orElseThrow(null);
	}
}
