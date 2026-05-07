package br.com.bibleoteca.Biblioteca_Portifolio.dto.usuario;

import br.com.bibleoteca.Biblioteca_Portifolio.model.Usuario;

public record UsuarioAltRequest(
    Long id,
    String nome,
    String email,
    String cpf,
    Usuario.StatusUsuario status
) {

}
