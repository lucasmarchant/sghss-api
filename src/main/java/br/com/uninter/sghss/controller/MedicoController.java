package br.com.uninter.sghss.controller;

import br.com.uninter.sghss.medico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
        return null;
    }

    @GetMapping
    public ResponseEntity <List<DadosListagemMedico>> listar(){
        var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemMedico::new).toList();
        return ResponseEntity.ok(lista);
    }


    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizaCadastroMedico dados){
        Medico medico = repository.findById(dados.id())
                        .orElseThrow(() -> new RuntimeException("Médico não encontrado!"));
        medico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    //Com exclusão lógica
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        Medico medico = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Médico não encontrado!"));
        medico.excluir();

        return ResponseEntity.noContent().build();
    }
}
