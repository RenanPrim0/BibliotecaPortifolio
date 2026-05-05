package br.com.bibleoteca.Biblioteca_Portifolio.dto.usuario;

import br.com.bibleoteca.Biblioteca_Portifolio.model.Usuario;

public record UsuarioResponse(
    Long id,
    String nome,
    String email,
    String cpf
) {
    public UsuarioResponse(Usuario usuario) {
        this(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail(),
            usuario.getCpf()
        );
    }
}
