package br.com.bibleoteca.Biblioteca_Portifolio.repository;

import br.com.bibleoteca.Biblioteca_Portifolio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
