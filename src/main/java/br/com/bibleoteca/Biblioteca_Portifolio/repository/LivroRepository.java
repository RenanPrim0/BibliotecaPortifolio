package br.com.bibleoteca.Biblioteca_Portifolio.repository;

import br.com.bibleoteca.Biblioteca_Portifolio.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro,Long> {
}
