package br.com.bibleoteca.Biblioteca_Portifolio.repository;

import br.com.bibleoteca.Biblioteca_Portifolio.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor,Long> {
}
