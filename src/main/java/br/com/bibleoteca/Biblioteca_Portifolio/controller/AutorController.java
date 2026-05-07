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
import br.com.bibleoteca.Biblioteca_Portifolio.dto.autor.AutorAltRequest;
import br.com.bibleoteca.Biblioteca_Portifolio.dto.autor.AutorRequest;
import br.com.bibleoteca.Biblioteca_Portifolio.dto.autor.AutorResponse;
import br.com.bibleoteca.Biblioteca_Portifolio.service.AutorService;


@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping("/cadastrar")
    public ResponseEntity<AutorResponse> criar(@RequestBody AutorRequest request) {
        return ResponseEntity.ok(autorService.salvar(request));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AutorResponse>> listarTodos() {
        return ResponseEntity.ok(autorService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(autorService.buscarPorId(id));
    }

    @PutMapping("/alterar")
    public ResponseEntity<AutorResponse> atualizar(@RequestBody AutorAltRequest request) {
        return ResponseEntity.ok(autorService.atualizar(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        autorService.deletar(id);
        return ResponseEntity.noContent().build();
    } 

}
