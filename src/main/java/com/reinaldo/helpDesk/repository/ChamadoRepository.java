package com.reinaldo.helpDesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reinaldo.helpDesk.domain.Chamado;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
