package br.com.bibleoteca.Biblioteca_Portifolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bibleoteca.Biblioteca_Portifolio.dto.livro.LivroAltRequest;
import br.com.bibleoteca.Biblioteca_Portifolio.dto.livro.LivroRequest;
import br.com.bibleoteca.Biblioteca_Portifolio.dto.livro.LivroResponse;
import br.com.bibleoteca.Biblioteca_Portifolio.service.LivroService;


@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping("/cadastrar")
    public ResponseEntity<LivroResponse> criar(@RequestBody LivroRequest request) {
        return ResponseEntity.ok(livroService.criar(request));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<LivroResponse>> listarTodos() {
        return ResponseEntity.ok(livroService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(livroService.buscarPorId(id));
    }

    @PutMapping("/alterar")
    public ResponseEntity<LivroResponse> atualizar(@RequestBody LivroAltRequest request) {
        return ResponseEntity.ok(livroService.atualizar(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
