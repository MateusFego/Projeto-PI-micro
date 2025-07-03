package br.edu.imepac.comum.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "especialidades")
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da especialidade é obrigatório.")
    @Column(nullable = false, unique = true)
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "especialidade")
    private List<Funcionario> funcionarios;
}
