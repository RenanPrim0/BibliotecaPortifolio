package br.com.bibleoteca.Biblioteca_Portifolio.dto.usuario;

public record UsuarioAltRequest(
    Long id,
    String nome,
    String email,
    String cpf
) {

}
