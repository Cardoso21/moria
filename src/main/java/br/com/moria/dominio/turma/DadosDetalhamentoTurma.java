package br.com.moria.dominio.turma;

import java.time.LocalDateTime;

public record DadosDetalhamentoTurma(Long id, Long idProfessor, Long idAluno, LocalDateTime data) {
}
