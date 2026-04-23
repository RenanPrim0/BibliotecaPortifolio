package br.com.bibleoteca.Biblioteca_Portifolio.repository;

import br.com.bibleoteca.Biblioteca_Portifolio.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}
