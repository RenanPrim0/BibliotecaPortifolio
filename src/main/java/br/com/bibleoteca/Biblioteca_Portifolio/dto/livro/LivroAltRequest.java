package br.com.bibleoteca.Biblioteca_Portifolio.dto.livro;

public record LivroAltRequest(
        Long id,
        String titulo,
        Integer anoPublicacao,
        String genero,
        Integer quantidade,
        Long autorId
) {

}
