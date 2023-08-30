package br.com.moria.dominio.professor;

import br.com.moria.enums.Curso;

public record DadosListagemProfessor(Long id, String nome, String email, String telefone, Curso curso){
    public DadosListagemProfessor(Professor professor){
        this(professor.getId(), professor.getNome(),professor.getEmail(),professor.getTelefone(),professor.getCurso());
    }
}
