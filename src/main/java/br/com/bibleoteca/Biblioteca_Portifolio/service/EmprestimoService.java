package br.com.bibleoteca.Biblioteca_Portifolio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.bibleoteca.Biblioteca_Portifolio.dto.emprestimo.EmprestimoRequest;
import br.com.bibleoteca.Biblioteca_Portifolio.dto.emprestimo.EmprestimoResponse;
import br.com.bibleoteca.Biblioteca_Portifolio.model.Emprestimo;
import br.com.bibleoteca.Biblioteca_Portifolio.model.Livro;
import br.com.bibleoteca.Biblioteca_Portifolio.model.Usuario;
import br.com.bibleoteca.Biblioteca_Portifolio.repository.EmprestimoRepository;
import br.com.bibleoteca.Biblioteca_Portifolio.repository.LivroRepository;
import br.com.bibleoteca.Biblioteca_Portifolio.repository.UsuarioRepository;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final LivroRepository livroRepository;
    private final UsuarioRepository usuarioRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository,
                             LivroRepository livroRepository,
                             UsuarioRepository usuarioRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.livroRepository = livroRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<EmprestimoResponse> listarTodos() {
        return emprestimoRepository.findAll()
                .stream()
                .map(EmprestimoResponse::new)
                .toList();
    }

    public EmprestimoResponse buscarPorId(Long id) {
        Emprestimo emprestimo = emprestimoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado com id: " + id));
        return new EmprestimoResponse(emprestimo);
    }

    public EmprestimoResponse criar(EmprestimoRequest request) {
        Livro livro = livroRepository.findById(request.livroId())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        Usuario usuario = usuarioRepository.findById(request.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (livro.getQuantidade() <= 0) {
            throw new RuntimeException("Livro sem estoque disponível");
        }

        livro.setQuantidade(livro.getQuantidade() - 1);
        livroRepository.save(livro);

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setLivro(livro);
        emprestimo.setUsuario(usuario);
        emprestimoRepository.save(emprestimo);

        return new EmprestimoResponse(emprestimo);
    }

    public EmprestimoResponse devolver(Long id) {
        Emprestimo emprestimo = emprestimoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));

        if (emprestimo.getStatus() == Emprestimo.StatusEmprestimo.DEVOLVIDO) {
            throw new RuntimeException("Livro já foi devolvido");
        }

        Livro livro = emprestimo.getLivro();
        livro.setQuantidade(livro.getQuantidade() + 1);
        livroRepository.save(livro);

        emprestimo.setStatus(Emprestimo.StatusEmprestimo.DEVOLVIDO);
        emprestimoRepository.save(emprestimo);

        return new EmprestimoResponse(emprestimo);
    }

    public void deletar(Long id) {
        if (!emprestimoRepository.existsById(id)) {
            throw new RuntimeException("Empréstimo não encontrado com id: " + id);
        }
        emprestimoRepository.deleteById(id);
    }
}