package br.com.bibleoteca.Biblioteca_Portifolio.dto.emprestimo;

public record EmprestimoRequest(
    Long livroId,
    Long usuarioId
) {

}
