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
import br.com.bibleoteca.Biblioteca_Portifolio.dto.emprestimo.EmprestimoRequest;
import br.com.bibleoteca.Biblioteca_Portifolio.dto.emprestimo.EmprestimoResponse;
import br.com.bibleoteca.Biblioteca_Portifolio.service.EmprestimoService;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<EmprestimoResponse> criar(@RequestBody EmprestimoRequest request) {
        return ResponseEntity.ok(emprestimoService.criar(request));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<EmprestimoResponse>> listarTodos() {
        return ResponseEntity.ok(emprestimoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(emprestimoService.buscarPorId(id));
    }

    @PutMapping("/devolver")
   public ResponseEntity<EmprestimoResponse> devolver(@PathVariable Long id) {
    return ResponseEntity.ok(emprestimoService.devolver(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        emprestimoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
