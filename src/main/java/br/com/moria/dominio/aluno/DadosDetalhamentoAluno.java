package br.com.moria.dominio.aluno;

import br.com.moria.dominio.endereco.Endereco;
import br.com.moria.enums.Curso;

public record DadosDetalhamentoAluno(Long id, String nome, String email, String telefone, Curso curso, Endereco endereco) {

    public DadosDetalhamentoAluno(Aluno aluno){
        this(aluno.getId(),aluno.getNome(),aluno.getEmail(),aluno.getTelefone(),aluno.getCurso(),aluno.getEndereco());
    }
}
