package br.com.bibleoteca.Biblioteca_Portifolio.dto.usuario;

import java.time.LocalDate;

import br.com.bibleoteca.Biblioteca_Portifolio.model.Usuario;

public record UsuarioResponse(
    Long id,
    String nome,
    String email,
    String cpf,
    String status,
    LocalDate dataCadastro
) {
    public UsuarioResponse(Usuario usuario) {
        this(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail(),
            usuario.getCpf(),
            usuario.getStatus().name(),
            usuario.getDataCadastro()
        );
    }
}
