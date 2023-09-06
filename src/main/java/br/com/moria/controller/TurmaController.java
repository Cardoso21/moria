package br.com.moria.controller;

import br.com.moria.dominio.turma.DadosCriacaoTurma;
import br.com.moria.dominio.turma.DadosDetalhamentoTurma;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("turmas")
@Transactional
public class TurmaController {

    @PostMapping
    public ResponseEntity turma(@RequestBody @Valid DadosCriacaoTurma dados){

        return ResponseEntity.ok(new DadosDetalhamentoTurma(null,null,null,null));
    }
}
