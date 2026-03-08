package br.com.uninter.sghss.domain.paciente;

import br.com.uninter.sghss.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    public Boolean getAtivo() {
        return ativo;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    @Embedded
    private Endereco endereco;
    private Boolean ativo;

    public Paciente(DadosCadastroPaciente dadosPaciente) {
        this.ativo = true;
        this.nome = dadosPaciente.nome();
        this.cpf = dadosPaciente.cpf();
        this.email = dadosPaciente.email();
        this.telefone = dadosPaciente.telefone();
        this.endereco = new Endereco(dadosPaciente.endereco());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Paciente() {
    }

    public void atualizarInformacoes(DadosAtualizaCadastroPaciente dadosPaciente) {
        if(dadosPaciente.nome() != null) {
            this.nome = dadosPaciente.nome();
        }
        if(dadosPaciente.telefone() != null) {
            this.telefone = dadosPaciente.telefone();
        }
        if(dadosPaciente.endereco() != null) {
            this.endereco.atualizarInformacoes(dadosPaciente.endereco());
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
