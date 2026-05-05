package br.com.bibleoteca.Biblioteca_Portifolio.service;

import java.util.List;

import org.springframework.stereotype.Service;
import br.com.bibleoteca.Biblioteca_Portifolio.dto.livro.LivroResponse;
import br.com.bibleoteca.Biblioteca_Portifolio.model.Autor;
import br.com.bibleoteca.Biblioteca_Portifolio.model.Livro;
import br.com.bibleoteca.Biblioteca_Portifolio.repository.AutorRepository;
import br.com.bibleoteca.Biblioteca_Portifolio.repository.LivroRepository;
import br.com.bibleoteca.Biblioteca_Portifolio.dto.livro.LivroAltRequest;
import br.com.bibleoteca.Biblioteca_Portifolio.dto.livro.LivroRequest;
@Service
public class LivroService {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;

    public LivroService(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    public List<LivroResponse> listarTodos() {
        return livroRepository.findAll()
                .stream()
                .map(LivroResponse::new)
                .toList();
    }

    public LivroResponse buscarPorId(Long id) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        return new LivroResponse(livro);
    }

   public LivroResponse criar(LivroRequest request) {
    Livro livro = new Livro();
    
    Autor autor = autorRepository.findById(request.autorId())
            .orElseThrow(() -> new RuntimeException("Autor não encontrado"));

    livro.setTitulo(request.titulo());
    livro.setAutor(autor);
    livro.setAnoPublicacao(request.anoPublicacao());
    livro.setGenero(Livro.Genero.valueOf(request.genero()));
    livro.setQuantidade(request.quantidade());
    livroRepository.save(livro);
    return new LivroResponse(livro);
}

    public LivroResponse atualizar(LivroAltRequest request) {
    Livro livro = livroRepository.findById(request.id())
            .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    
    Autor autor = autorRepository.findById(request.autorId())
            .orElseThrow(() -> new RuntimeException("Autor não encontrado"));

    livro.setTitulo(request.titulo());
    livro.setAutor(autor);
    livro.setAnoPublicacao(request.anoPublicacao());
    livro.setGenero(Livro.Genero.valueOf(request.genero()));
    livro.setQuantidade(request.quantidade());
    livroRepository.save(livro);
    return new LivroResponse(livro);
}

    public void deletar(Long id) {
        buscarPorId(id);
        livroRepository.deleteById(id);
    }
}