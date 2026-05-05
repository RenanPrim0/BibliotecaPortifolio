package br.com.bibleoteca.Biblioteca_Portifolio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Email(message = "Email deve ser válido")
    private String email;

    private String cpf;

    private LocalDate dataCadastro;

    @Enumerated(EnumType.STRING)
    private StatusUsuario status;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Emprestimo> emprestimos;

    @PrePersist
    public void prePersist() {
        this.dataCadastro = LocalDate.now();
        if (this.status == null) this.status = StatusUsuario.ATIVO;
    }

    public enum StatusUsuario {
        ATIVO,  INATIVO, BLOQUEADO
    }
}
