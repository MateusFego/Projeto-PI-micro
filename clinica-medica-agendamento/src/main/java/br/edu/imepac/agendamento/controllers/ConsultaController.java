package br.edu.imepac.agendamento.controllers;

import br.edu.imepac.comum.dtos.consulta.ConsultaDto;
import br.edu.imepac.comum.dtos.consulta.ConsultaRequest;
import br.edu.imepac.comum.security.Permissao;
import br.edu.imepac.comum.services.ConsultaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('" + Permissao.CADASTRAR_CONSULTA + "')")
    public ConsultaDto criarConsulta(@RequestBody ConsultaRequest consultaRequest) {
        log.info("Criando consulta - controller: {}", consultaRequest);
        return consultaService.adicionarConsulta(consultaRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('" + Permissao.ATUALIZAR_CONSULTA + "')")
    public ConsultaDto atualizarConsulta(@PathVariable Long id, @RequestBody ConsultaDto consultaDto) {
        log.info("Atualizar consulta - controller: {}", consultaDto);
        return consultaService.atualizarConsulta(id, consultaDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('" + Permissao.DELETAR_CONSULTA + "')")
    public void removerConsulta(@PathVariable Long id) {
        log.info("Remover consulta - controller: {}", id);
        consultaService.removerConsulta(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('" + Permissao.LER_CONSULTA + "')")
    public ConsultaDto buscarConsultaPorId(@PathVariable Long id) {
        log.info("Buscar consulta - controller: {}", id);
        return consultaService.buscarConsultaPorId(id);
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('" + Permissao.LISTAR_CONSULTA + "')")
    public List<ConsultaDto> listarConsultas() {
        log.info("Listar consulta - controller");
        return consultaService.listarConsultas();
    }
}
