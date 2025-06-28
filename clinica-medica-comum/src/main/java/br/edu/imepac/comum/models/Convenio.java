package br.edu.imepac.comum.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "convenios")
public class Convenio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

    @MapsId
    @OneToOne(mappedBy = "convenio")
    @JoinColumn(name = "id")
    private Consulta consulta;
}
