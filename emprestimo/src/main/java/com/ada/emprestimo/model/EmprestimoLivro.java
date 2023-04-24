package com.ada.emprestimo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="EMPRESTIMO_LIVRO")
public class EmprestimoLivro {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_emprestimo_livro")
    private Integer id;

    @Column(name = "protocolo")
    private Integer protocolo;

    @Column(name = "id_livro")
    private Integer idLivro;
}
