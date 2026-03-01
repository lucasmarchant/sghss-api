package br.com.uninter.sghss.controller;

import br.com.uninter.sghss.paciente.DadosCadastroPaciente;
import br.com.uninter.sghss.paciente.Paciente;
import br.com.uninter.sghss.paciente.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dadosPaciente){
        repository.save(new Paciente(dadosPaciente));
    }

}
