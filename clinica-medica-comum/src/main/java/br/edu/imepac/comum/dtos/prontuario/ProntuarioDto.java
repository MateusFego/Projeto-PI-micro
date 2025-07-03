package br.edu.imepac.comum.dtos.prontuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProntuarioDto {
    private Long id;
    private String receituario;
    private String exames;
    private String observacoes;
}
