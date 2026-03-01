package br.com.uninter.sghss.paciente;

import br.com.uninter.sghss.endereco.DadosEndereco;

public record DadosCadastroPaciente(

        String nome,
        String email,
        String telefone,
        String cpf,
        DadosEndereco endereco) {
}
