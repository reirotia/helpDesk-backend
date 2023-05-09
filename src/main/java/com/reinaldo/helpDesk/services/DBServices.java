package com.reinaldo.helpDesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reinaldo.helpDesk.domain.Chamado;
import com.reinaldo.helpDesk.domain.Cliente;
import com.reinaldo.helpDesk.domain.Tecnico;
import com.reinaldo.helpDesk.domain.enums.Perfil;
import com.reinaldo.helpDesk.domain.enums.Prioridade;
import com.reinaldo.helpDesk.domain.enums.Status;
import com.reinaldo.helpDesk.repository.ChamadoRepository;
import com.reinaldo.helpDesk.repository.ClienteRepository;
import com.reinaldo.helpDesk.repository.TecnicoRepository;

@Service
public class DBServices {
	@Autowired	
	private TecnicoRepository tecnicoRepo;
	@Autowired	
	private ClienteRepository clienteRepo;
	@Autowired	
	private ChamadoRepository chamadoRepo;

	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null,"Reinaldoss", "49847710031", "r@gmail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		Cliente cli1 = new Cliente(null, "Rosalia", "49342708099", "ro@gmail.com", "123");
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		
		tecnicoRepo.saveAll(Arrays.asList(tec1));
		clienteRepo.saveAll(Arrays.asList(cli1));
		chamadoRepo.saveAll(Arrays.asList(c1));
		
	}
}
