package br.com.uninter.sghss.medico;

import br.com.uninter.sghss.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaCadastroMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
