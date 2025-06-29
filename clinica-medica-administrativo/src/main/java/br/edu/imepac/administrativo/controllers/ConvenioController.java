package br.edu.imepac.administrativo.controllers;

import br.edu.imepac.comum.dtos.convenio.ConvenioDto;
import br.edu.imepac.comum.dtos.convenio.ConvenioRequest;
import br.edu.imepac.comum.security.Permissao;
import br.edu.imepac.comum.services.ConvenioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/convenios")
public class ConvenioController {
    private final ConvenioService convenioService;

    public ConvenioController(ConvenioService convenioService){
        this.convenioService = convenioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('" + Permissao.CADASTRAR_CONVENIO + "')")
    public ConvenioDto criarConvenio(@RequestBody ConvenioRequest convenioRequest) {
        log.info("Criando convenio - controller: {}", convenioRequest);
        return convenioService.adicionarConvenio(convenioRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('" + Permissao.ATUALIZAR_CONVENIO + "')")
    public ConvenioDto atualizarConvenio(@PathVariable Long id, @RequestBody ConvenioDto convenioDto) {
        log.info("Atualizar convenio - controller: {}", convenioDto);
        return convenioService.atualizarConvenio(id, convenioDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('" + Permissao.DELETAR_CONVENIO + "')")
    public void removerConvenio(@PathVariable Long id) {
        log.info("Remover convenio - controller: {}", id);
        convenioService.removerConvenio(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('" + Permissao.LER_CONVENIO + "')")
    public ConvenioDto buscarConvenioPorId(@PathVariable Long id) {
        log.info("Buscar convenio - controller: {}", id);
        return convenioService.buscarConvenioPorId(id);
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('" + Permissao.LISTAR_CONVENIO + "')")
    public List<ConvenioDto> listarConvenios() {
        log.info("Listar convenio - controller");
        return convenioService.listarConvenios();
    }
}