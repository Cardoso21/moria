package br.com.moria.dominio.professor;

import br.com.moria.dominio.endereco.Endereco;
import br.com.moria.enums.Curso;

public record DadosDetalhamentosProfessor(Long id, String nome, String email, String telefone, Curso curso, Endereco endereco) {

    public DadosDetalhamentosProfessor(Professor professor) {
        this(professor.getId(), professor.getNome(), professor.getEmail(), professor.getTelefone(), professor.getCurso(), professor.getEndereco());
    }


}