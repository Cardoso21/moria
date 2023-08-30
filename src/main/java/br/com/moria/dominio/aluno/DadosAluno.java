package br.com.moria.dominio.aluno;

import br.com.moria.dominio.endereco.DadosEndereco;
import br.com.moria.enums.Curso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAluno(
     @NotBlank
     String nome,
     @NotBlank
     @Email
     String email,
     @NotBlank
     @Pattern(regexp = "\\d{11}")
     String telefone,
     @NotNull
     Curso curso,
     @NotNull
     @Valid
     DadosEndereco endereco) {
}
