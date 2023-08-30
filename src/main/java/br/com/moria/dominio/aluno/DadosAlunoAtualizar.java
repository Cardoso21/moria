package br.com.moria.dominio.aluno;

import br.com.moria.dominio.endereco.DadosEndereco;
import br.com.moria.enums.Curso;
import jakarta.validation.constraints.NotNull;

public record DadosAlunoAtualizar(
        @NotNull
        Long id,
        String nome,
        String email,
        String telefone,
        Curso curso,
        DadosEndereco endereco) {
}
