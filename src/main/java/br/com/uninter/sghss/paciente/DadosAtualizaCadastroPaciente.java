package br.com.uninter.sghss.paciente;

import br.com.uninter.sghss.endereco.DadosEndereco;
import br.com.uninter.sghss.endereco.Endereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaCadastroPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
