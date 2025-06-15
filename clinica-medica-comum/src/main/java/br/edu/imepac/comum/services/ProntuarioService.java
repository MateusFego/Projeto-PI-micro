package br.edu.imepac.comum.services;

import br.edu.imepac.comum.dtos.prontuario.ProntuarioDto;
import br.edu.imepac.comum.dtos.prontuario.ProntuarioRequest;
import br.edu.imepac.comum.models.Prontuario;
import br.edu.imepac.comum.repositories.ProntuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProntuarioService {

    private final ModelMapper modelMapper;
    private final ProntuarioRepository repository;

    public ProntuarioService(ModelMapper modelMapper, ProntuarioRepository repository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    public ProntuarioDto adicionar(ProntuarioRequest request) {
        log.info("Cadastro de prontuário: {}", request);
        Prontuario p = modelMapper.map(request, Prontuario.class);
        p = repository.save(p);
        return modelMapper.map(p, ProntuarioDto.class);
    }

    public ProntuarioDto atualizar(Long id, ProntuarioDto dto) {
        log.info("Atualizando prontuário com ID: {}", id);
        Prontuario existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prontuário não encontrado com ID: " + id));
        modelMapper.map(dto, existente);
        Prontuario atualizado = repository.save(existente);
        return modelMapper.map(atualizado, ProntuarioDto.class);
    }

    public void remover(Long id) {
        log.info("Removendo prontuário com ID: {}", id);
        Prontuario p = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prontuário não encontrado com ID: " + id));
        repository.delete(p);
    }

    public ProntuarioDto buscarPorId(Long id) {
        log.info("Buscando prontuário com ID: {}", id);
        Prontuario p = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prontuário não encontrado com ID: " + id));
        return modelMapper.map(p, ProntuarioDto.class);
    }

    public List<ProntuarioDto> listar() {
        log.info("Listando todos os prontuários");
        return repository.findAll().stream()
                .map(p -> modelMapper.map(p, ProntuarioDto.class))
                .toList();
    }
}
