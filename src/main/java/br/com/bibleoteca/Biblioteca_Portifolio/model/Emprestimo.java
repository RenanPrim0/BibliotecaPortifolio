package br.com.bibleoteca.Biblioteca_Portifolio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "emprestimos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "livro_id")
    @ManyToOne
    private Livro livro;

    @JoinColumn(name = "usuario_id")
    @ManyToOne
    private Usuario usuario;

    private LocalDate dataEmprestimo;

    private LocalDate dataDevolucaoPrevista;

    private LocalDate dataDevolucaoReal;

    @Enumerated(EnumType.STRING)
    private StatusEmprestimo status;

    @PrePersist
    public void prePersist()
    {
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucaoPrevista = LocalDate.now().plusDays(14);
        if (this.status == null) this.status = StatusEmprestimo.ATIVO;
    }

    public enum StatusEmprestimo {
        ATIVO, DEVOLVIDO, ATRASADO
    }
}
