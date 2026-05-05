package br.com.bibleoteca.Biblioteca_Portifolio.service;

import br.com.bibleoteca.Biblioteca_Portifolio.dto.usuario.UsuarioAltRequest;
import br.com.bibleoteca.Biblioteca_Portifolio.dto.usuario.UsuarioRequest;
import br.com.bibleoteca.Biblioteca_Portifolio.dto.usuario.UsuarioResponse;
import br.com.bibleoteca.Biblioteca_Portifolio.model.Usuario;
import br.com.bibleoteca.Biblioteca_Portifolio.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioResponse salvar(UsuarioRequest request) {
        Usuario usuario = new Usuario();
        usuario.setNome(request.nome());
        usuario.setEmail(request.email());
        usuario.setCpf(request.cpf());
        usuarioRepository.save(usuario);
        return new UsuarioResponse(usuario);
    }

    public List<UsuarioResponse> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(UsuarioResponse::new)
                .toList();
    }

    public UsuarioResponse buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado" + id));
        return new UsuarioResponse(usuario);
    }

    public UsuarioResponse atualizar(UsuarioAltRequest request) {
        Usuario usuario = usuarioRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado" + request.id()));
        usuario.setNome(request.nome());
        usuario.setEmail(request.email());
        usuario.setCpf(request.cpf());
        usuarioRepository.save(usuario);
        return new UsuarioResponse(usuario);
    }

    public void deletar(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado" + id));
        usuarioRepository.delete(usuario);
    }

}   