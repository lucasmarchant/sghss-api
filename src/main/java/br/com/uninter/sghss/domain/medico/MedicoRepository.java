package br.com.uninter.sghss.domain.medico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    List<Medico> findAllByAtivoTrue();

}
