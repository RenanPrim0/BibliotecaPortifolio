package br.com.bibleoteca.Biblioteca_Portifolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bibleoteca.Biblioteca_Portifolio.dto.autor.AutorAltRequest;
import br.com.bibleoteca.Biblioteca_Portifolio.dto.autor.AutorRequest;
import br.com.bibleoteca.Biblioteca_Portifolio.dto.autor.AutorResponse;
import br.com.bibleoteca.Biblioteca_Portifolio.model.Autor;
import br.com.bibleoteca.Biblioteca_Portifolio.repository.AutorRepository;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public AutorResponse salvar(AutorRequest request) {
        Autor autor = new Autor();
        autor.setNome(request.nome());
        autor.setAnoNascimento(request.anoNascimento());
        autor.setBiografia(request.biografia());
        autorRepository.save(autor);
        return new AutorResponse(autor);
    }

    public List<AutorResponse> listarTodos() {
        return autorRepository.findAll().stream().map(AutorResponse::new).toList();
    }

    public AutorResponse buscarPorId(Long id) {
        Autor autor = autorRepository.findById(id).orElseThrow(() -> new RuntimeException("Autor não encontrado com id" + id));
        return new AutorResponse(autor);
    }

    public AutorResponse atualizar(AutorAltRequest request) {
        Autor autor = autorRepository.findById(request.id())
            .orElseThrow(() -> new RuntimeException("Autor não encontrado com id:" + request.id()));

        autor.setNome(request.nome());
        autor.setAnoNascimento(request.anoNascimento());
        autor.setBiografia(request.biografia());
        autorRepository.save(autor);
        return new AutorResponse(autor);
    }

    public void deletar(Long id) {
        if (!autorRepository.existsById(id)) {
            throw new RuntimeException("Mecânico não encontrado com id: " + id);
        }
        autorRepository.deleteById(id);
    }
    
}
