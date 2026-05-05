package br.com.bibleoteca.Biblioteca_Portifolio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "livros")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private Integer anoPublicacao;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL)
    private List<Emprestimo> emprestimos;

    public enum Genero {
        FICCAO, FANTASIA, SUSPENSE, ROMANCE, BIOGRAFIA, HISTORIA
    }
}
