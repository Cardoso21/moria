package br.com.moria.controller;

import br.com.moria.dominio.professor.*;
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
@RequestMapping("/professor")
@Transactional
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @PostMapping
    public ResponseEntity cadastrar (@RequestBody @Valid DadosProfessor dados, UriComponentsBuilder uriBuilder){
        var professor = new Professor(dados);
        repository.save(professor);
        var uri = uriBuilder.path("/professor/{id}").buildAndExpand(professor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentosProfessor(professor));
    }

    @GetMapping
    public ResponseEntity <Page<DadosListagemProfessor>> listar(@PageableDefault(size = 10,sort = {"nome"}) Pageable paginacao){
        var page= repository.findAllByStatusTrue(paginacao).map(DadosListagemProfessor::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid DadosProfessorAtualizar dados){
        var professor = repository.getReferenceById(dados.id());
        professor.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentosProfessor(professor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        var professor = repository.getReferenceById(id);
        professor.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var professor = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentosProfessor(professor));
    }

}
