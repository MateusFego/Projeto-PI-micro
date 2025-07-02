package br.edu.imepac.comum.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prontuarios")
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String receituario;

    @Lob
    private String exames;

    private String observacoes;

    @MapsId
    @OneToOne(mappedBy = "prontuario")
    @JoinColumn(name = "id")
    private Consulta consulta;
}
