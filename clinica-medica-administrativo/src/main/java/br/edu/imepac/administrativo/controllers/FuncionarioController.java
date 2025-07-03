package br.edu.imepac.administrativo.controllers;

import br.edu.imepac.comum.dtos.funcionario.FuncionarioDto;
import br.edu.imepac.comum.dtos.funcionario.FuncionarioRequest;
import br.edu.imepac.comum.security.Permissao;
import br.edu.imepac.comum.services.FuncionarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('" + Permissao.CADASTRAR_FUNCIONARIO + "')")
    public FuncionarioDto criarFuncionario(@RequestBody FuncionarioRequest funcionarioRequest) {
        log.info("Criando funcionário - controller: {}", funcionarioRequest);
        return funcionarioService.adicionarFuncionario(funcionarioRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('" + Permissao.ATUALIZAR_FUNCIONARIO + "')")
    public FuncionarioDto atualizarFuncionario(@PathVariable Long id, @RequestBody FuncionarioDto funcionarioDto) {
        log.info("Atualizar funcionário - controller: {}", funcionarioDto);
        return funcionarioService.atualizarFuncionario(id, funcionarioDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('" + Permissao.DELETAR_FUNCIONARIO + "')")
    public void removerFuncionario(@PathVariable Long id) {
        log.info("Remover funcionário - controller: {}", id);
        funcionarioService.removerFuncionario(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('" + Permissao.LER_FUNCIONARIO + "')")
    public FuncionarioDto buscarFuncionarioPorId(@PathVariable Long id) {
        log.info("Buscar funcionário - controller: {}", id);
        return funcionarioService.buscarFuncionarioPorId(id);
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('" + Permissao.LISTAR_FUNCIONARIO + "')")
    public List<FuncionarioDto> listarFuncionarios() {
        log.info("Listar funcionários - controller");
        return funcionarioService.listarFuncionarios();
    }
}