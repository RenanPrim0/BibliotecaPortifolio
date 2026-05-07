package br.com.bibleoteca.Biblioteca_Portifolio.dto.emprestimo;

import java.time.LocalDate;

public record EmprestimoAltRequest(
    Long id,
    LocalDate dataDevolucaoReal,
    String status
) {

}
