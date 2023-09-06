package br.com.moria.dominio.turma;

import br.com.moria.dominio.aluno.Aluno;
import br.com.moria.dominio.professor.Professor;
import br.com.moria.enums.Curso;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "turmas")
@Entity(name = "turma")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @NotBlank
    private Curso curso;

    @ManyToMany
    @JoinTable(name = "aluno_turma",joinColumns = {
            @JoinColumn(name = "turma_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "aluno_id")
    })
    private List<Aluno> aluno;

    private LocalDateTime data;
}
