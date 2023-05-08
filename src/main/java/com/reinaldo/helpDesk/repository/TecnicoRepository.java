package com.reinaldo.helpDesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reinaldo.helpDesk.domain.Cliente;
import com.reinaldo.helpDesk.domain.Tecnico;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
