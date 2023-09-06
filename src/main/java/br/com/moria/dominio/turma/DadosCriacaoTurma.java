package br.com.moria.dominio.turma;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCriacaoTurma(
        Long idProfessor,
        @NotNull
        Long idAluno,
        @NotNull
        @Future
        LocalDateTime data) {
}
