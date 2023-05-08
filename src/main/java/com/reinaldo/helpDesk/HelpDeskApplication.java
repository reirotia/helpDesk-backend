package com.reinaldo.helpDesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.reinaldo.helpDesk.domain.Chamado;
import com.reinaldo.helpDesk.domain.Cliente;
import com.reinaldo.helpDesk.domain.Tecnico;
import com.reinaldo.helpDesk.domain.enums.Perfil;
import com.reinaldo.helpDesk.domain.enums.Prioridade;
import com.reinaldo.helpDesk.domain.enums.Status;
import com.reinaldo.helpDesk.repository.ChamadoRepository;
import com.reinaldo.helpDesk.repository.ClienteRepository;
import com.reinaldo.helpDesk.repository.TecnicoRepository;

@SpringBootApplication
public class HelpDeskApplication implements CommandLineRunner {

	@Autowired	
	private TecnicoRepository tecnicoRepo;
	@Autowired	
	private ClienteRepository clienteRepo;
	@Autowired	
	private ChamadoRepository chamadoRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(HelpDeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Tecnico tec1 = new Tecnico(null,"Reinaldo", "49847710031", "r@gmail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		Cliente cli1 = new Cliente(null, "Rosalia", "49342708099", "ro@gmail.com", "123");
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		
		tecnicoRepo.saveAll(Arrays.asList(tec1));
		clienteRepo.saveAll(Arrays.asList(cli1));
		chamadoRepo.saveAll(Arrays.asList(c1));
		

		
	}

}
