package br.com.moria.dominio.aluno;

import br.com.moria.dominio.endereco.Endereco;
import br.com.moria.enums.Curso;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Aluno")
@Table(name = "aluno")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private Curso curso;
    @Embedded
    private Endereco endereco;

    private boolean status;

    public Aluno(DadosAluno dados) {
        this.status=true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.curso = dados.curso();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAlunoAtualizar dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.curso() != null){
            this.curso = dados.curso();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }

    }

    public void excluir() {
        this.status=false;
    }
}
