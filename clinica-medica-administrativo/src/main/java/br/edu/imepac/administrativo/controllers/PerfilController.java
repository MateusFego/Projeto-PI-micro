package br.edu.imepac.administrativo.controllers;

import br.edu.imepac.comum.dtos.perfil.PerfilDto;
import br.edu.imepac.comum.dtos.perfil.PerfilRequest;
import br.edu.imepac.comum.security.Permissao;
import br.edu.imepac.comum.services.PerfilService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/perfils")
public class PerfilController {
    private final PerfilService perfilService;

    public PerfilController(PerfilService perfilService){
        this.perfilService = perfilService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('" + Permissao.CADASTRAR_PERFIL + "')")
    public PerfilDto criarPerfil(@RequestBody PerfilRequest perfilRequest) {
        log.info("Criando perfil - controller: {}", perfilRequest);
        return perfilService.adicionarPerfil(perfilRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('" + Permissao.ATUALIZAR_PERFIL + "')")
    public PerfilDto atualizarPerfil(@PathVariable Long id, @RequestBody PerfilDto perfilDto) {
        log.info("Atualizar perfil - controller: {}", perfilDto);
        return perfilService.atualizarPerfil(id, perfilDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('" + Permissao.DELETAR_PERFIL + "')")
    public void removerPerfil(@PathVariable Long id) {
        log.info("Remover perfil - controller: {}", id);
        perfilService.removerPerfil(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('" + Permissao.LER_PERFIL + "')")
    public PerfilDto buscarPerfilPorId(@PathVariable Long id) {
        log.info("Buscar perfil - controller: {}", id);
        return perfilService.buscarPerfilPorId(id);
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('" + Permissao.LISTAR_PERFIL + "')")
    public List<PerfilDto> listarPerfis() {
        log.info("Listar perfil - controller");
        return perfilService.listarPerfis();
    }
}