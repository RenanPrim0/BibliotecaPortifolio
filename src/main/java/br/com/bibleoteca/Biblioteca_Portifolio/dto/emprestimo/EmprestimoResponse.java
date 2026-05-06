package br.com.bibleoteca.Biblioteca_Portifolio.dto.emprestimo;

import java.time.LocalDate;

import br.com.bibleoteca.Biblioteca_Portifolio.model.Emprestimo;

public record EmprestimoResponse(
    Long id,
    String livroTitulo,
    String usarioNome,
    LocalDate dataEmprestimo,
    LocalDate dataDevolucaoPrevista,
    LocalDate dataDevolucaoReal,
    String status
) {
    public EmprestimoResponse(Emprestimo emprestimo) {
        this(
            emprestimo.getId(),
            emprestimo.getLivro().getTitulo(),
            emprestimo.getUsuario().getNome(),
            emprestimo.getDataEmprestimo(),
            emprestimo.getDataDevolucaoPrevista(),
            emprestimo.getDataDevolucaoReal(),
            emprestimo.getStatus().name()
        );
    }
}
