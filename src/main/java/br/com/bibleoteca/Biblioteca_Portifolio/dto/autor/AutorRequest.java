package br.com.bibleoteca.Biblioteca_Portifolio.dto.autor;

public record AutorRequest(
    String nome,
    Integer anoNascimento,
    String biografia
) {
    
}
