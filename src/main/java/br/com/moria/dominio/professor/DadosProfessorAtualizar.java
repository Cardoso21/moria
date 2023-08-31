package br.com.moria.dominio.professor;

import br.com.moria.dominio.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosProfessorAtualizar(
        @NotNull
        Long id,
        String nome,
        String email,
        String telefone,
        DadosEndereco endereco) {
}
