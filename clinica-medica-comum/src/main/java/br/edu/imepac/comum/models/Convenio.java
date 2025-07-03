package br.edu.imepac.comum.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "convenios")
public class Convenio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

//    @MapsId
//    @OneToOne(mappedBy = "convenio")
//    @JoinColumn(name = "id")
//    private Consulta consulta;

//    @OneToOne
//    @JoinColumn(name = "consulta_id")
    @OneToMany(mappedBy = "convenio")
    private List<Consulta> consulta;
}
