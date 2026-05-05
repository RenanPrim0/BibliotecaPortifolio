package br.com.bibleoteca.Biblioteca_Portifolio.dto.usuario;

public record UsuarioRequest(
    String nome,
    String email,
    String cpf
) {

}
