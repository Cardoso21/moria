package br.com.moria.controller;

import br.com.moria.dominio.aluno.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/aluno")
@Transactional
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @GetMapping
    public ResponseEntity<Page<DadosListagemAluno<Object>>> listar(@PageableDefault(size = 10,sort = {"nome"}) Pageable paginacao){
        var page= repository.findAllByStatusTrue(paginacao).map(DadosListagemAluno::new);
        return ResponseEntity.ok(page);
    }
    @PostMapping
    public ResponseEntity cadastra(@RequestBody @Valid DadosAluno dados, UriComponentsBuilder uriBuilder){
        var aluno = new Aluno(dados);
        repository.save(new Aluno(dados));
        var uri = uriBuilder.path("/aluno/{id}").buildAndExpand(aluno.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoAluno(aluno));
    }
    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid DadosAlunoAtualizar dados){
        var aluno = repository.getReferenceById(dados.id());
        aluno.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoAluno(aluno));
    }
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        var aluno = repository.getReferenceById(id);
        aluno.excluir();
    }
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var aluno = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoAluno(aluno));
    }
}
