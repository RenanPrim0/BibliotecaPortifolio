package br.com.bibleoteca.Biblioteca_Portifolio.dto.autor;

public record AutorAltRequest(
    long id,
    String nome,
    Integer anoNascimento,
    String biografia
) {

}
