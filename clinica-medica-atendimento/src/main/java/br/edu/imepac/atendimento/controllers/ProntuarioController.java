package br.edu.imepac.atendimento.controllers;

import br.edu.imepac.comum.dtos.prontuario.ProntuarioDto;
import br.edu.imepac.comum.dtos.prontuario.ProntuarioRequest;
import br.edu.imepac.comum.services.ProntuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/prontuarios")
public class ProntuarioController {
    private final ProntuarioService prontuarioService;

    public ProntuarioController(ProntuarioService prontuarioService) {
        this.prontuarioService = prontuarioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProntuarioDto criarProntuario(@RequestBody ProntuarioRequest prontuarioRequest) {
        log.info("Criando prontuario - controller: {}", prontuarioRequest);
        return prontuarioService.adicionarProntuario(prontuarioRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProntuarioDto atualizarProntuario(@PathVariable Long id, @RequestBody ProntuarioDto prontuarioDto) {
        log.info("Atualizar prontuario - controller: {}", prontuarioDto);
        return prontuarioService.atualizarProntuario(id, prontuarioDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerProntuario(@PathVariable Long id) {
        log.info("Remover prontuario - controller: {}", id);
        prontuarioService.removerProntuario(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProntuarioDto buscarProntuarioPorId(@PathVariable Long id) {
        log.info("Buscar prontuario - controller: {}", id);
        return prontuarioService.buscarProntuarioPorId(id);
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<ProntuarioDto> listarProntuarios() {
        log.info("Listar prontuario - controller");
        return prontuarioService.listarProntuarios();
    }
}
