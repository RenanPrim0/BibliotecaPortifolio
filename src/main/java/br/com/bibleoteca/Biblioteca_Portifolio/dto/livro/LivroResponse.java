package br.com.bibleoteca.Biblioteca_Portifolio.dto.livro;

import br.com.bibleoteca.Biblioteca_Portifolio.model.Livro;

public record LivroResponse(
        Long id,
        String titulo,
        Integer anoPublicacao,
        String genero,
        Integer quantidade,
        String autorNome
) {
    public LivroResponse(Livro livro) {
        this(livro.getId(), 
        livro.getTitulo(), 
        livro.getAnoPublicacao(), 
        livro.getGenero().name(), 
        livro.getQuantidade(), 
        livro.getAutor().getNome());
    }
}
