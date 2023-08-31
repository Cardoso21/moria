package br.com.moria.controller;

import br.com.moria.dominio.usuario.DadosAutenticacao;
import br.com.moria.dominio.usuario.Usuario;
import br.com.moria.infra.security.DadosTokenJWT;
import br.com.moria.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
        var autenticacaotoken = new UsernamePasswordAuthenticationToken(dados.login(),dados.senha());
        var autentication = manager.authenticate(autenticacaotoken);
        var tokenJWT = tokenService.gerarToken((Usuario) autentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
