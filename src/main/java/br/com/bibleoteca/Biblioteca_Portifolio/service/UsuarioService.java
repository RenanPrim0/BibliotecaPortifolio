package br.com.bibleoteca.Biblioteca_Portifolio.service;

import br.com.bibleoteca.Biblioteca_Portifolio.model.Livro;
import br.com.bibleoteca.Biblioteca_Portifolio.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final LivroRepository livroRepository;

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public Livro buscarPorId(Long id) {
        return livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    public Livro atualizar(Long id, Livro livroAtualizado) {
        Livro livro = buscarPorId(id);
        livro.setTitulo(livroAtualizado.getTitulo());
        livro.setAutor(livroAtualizado.getAutor());
        livro.setIsbn(livroAtualizado.getIsbn());
        livro.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
        livro.setGenero(livroAtualizado.getGenero());
        livro.setQuantidade(livroAtualizado.getQuantidade());
        return livroRepository.save(livro);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        livroRepository.deleteById(id);
    }
}