package br.com.bibleoteca.Biblioteca_Portifolio.dto.autor;

public record AutorAltRequest(
    Long id,
    String nome,
    Integer anoNascimento,
    String biografia
) {

}
