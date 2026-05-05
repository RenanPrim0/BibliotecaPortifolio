package br.com.bibleoteca.Biblioteca_Portifolio.dto.autor;

import br.com.bibleoteca.Biblioteca_Portifolio.model.Autor;

public record AutorResponse(
    long id,
    String nome,
    Integer anoNascimento,
    String biografia
) {
    public AutorResponse(Autor autor){
        this(autor.getId(), autor.getNome(), autor.getAnoNascimento(), autor.getBiografia());
    }
}
