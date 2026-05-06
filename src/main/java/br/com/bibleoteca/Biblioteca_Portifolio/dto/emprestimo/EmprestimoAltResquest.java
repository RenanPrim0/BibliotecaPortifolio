package br.com.bibleoteca.Biblioteca_Portifolio.dto.emprestimo;

import java.time.LocalDate;

public record EmprestimoAltResquest(
    Long id,
    LocalDate dataDevolucaoReal,
    String status
) {

}
