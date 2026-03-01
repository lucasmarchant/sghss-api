package br.com.uninter.sghss.controller;

import br.com.uninter.sghss.paciente.DadosCadastroPaciente;
import br.com.uninter.sghss.paciente.DadosListagemPaciente;
import br.com.uninter.sghss.paciente.Paciente;
import br.com.uninter.sghss.paciente.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public Page<DadosListagemPaciente> listar(Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemPaciente::new);
    }

}
