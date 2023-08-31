package br.com.moria.dominio.aluno;

import br.com.moria.enums.Curso;

public record DadosListagemAluno<LocalDateDate>(Long id, String nome, String email, String telefone, Curso curso) {
    public DadosListagemAluno(Aluno aluno){
        this(aluno.getId(),aluno.getNome(),aluno.getEmail(),aluno.getTelefone(), aluno.getCurso());
    }
}
