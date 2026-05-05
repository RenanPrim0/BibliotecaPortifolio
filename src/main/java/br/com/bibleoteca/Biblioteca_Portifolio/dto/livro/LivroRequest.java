package br.com.bibleoteca.Biblioteca_Portifolio.dto.livro;

public record LivroRequest(
        String titulo,
        Long autorId,
        Integer anoPublicacao,
        String genero,
        Integer quantidade
) {

}
