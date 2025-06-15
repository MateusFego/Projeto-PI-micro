package br.edu.imepac.comum.services;

import br.edu.imepac.comum.dtos.consulta.ConsultaDto;
import br.edu.imepac.comum.dtos.consulta.ConsultaRequest;
import br.edu.imepac.comum.models.Consulta;
import br.edu.imepac.comum.repositories.ConsultaRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ConsultaService {

    private final ModelMapper modelMapper;
    private final ConsultaRepository repository;

    public ConsultaService(ModelMapper modelMapper, ConsultaRepository repository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    public ConsultaDto adicionarConsulta(ConsultaRequest request) {
        log.info("Cadastro de consulta: {}", request);
        Consulta consulta = modelMapper.map(request, Consulta.class);
        consulta = repository.save(consulta);
        return modelMapper.map(consulta, ConsultaDto.class);
    }

    public ConsultaDto atualizarConsulta(Long id, ConsultaDto dto) {
        log.info("Atualizando consulta com ID: {}", id);
        Consulta existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada com ID: " + id));
        modelMapper.map(dto, existente);
        Consulta atualizado = repository.save(existente);
        return modelMapper.map(atualizado, ConsultaDto.class);
    }

    public void removerConsulta(Long id) {
        log.info("Removendo consulta com ID: {}", id);
        Consulta consulta = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada com ID: " + id));
        repository.delete(consulta);
    }

    public ConsultaDto buscarPorId(Long id) {
        log.info("Buscando consulta com ID: {}", id);
        Consulta consulta = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada com ID: " + id));
        return modelMapper.map(consulta, ConsultaDto.class);
    }

    public List<ConsultaDto> listar() {
        log.info("Listando todas as consultas");
        return repository.findAll().stream()
                .map(c -> modelMapper.map(c, ConsultaDto.class))
                .toList();
    }
}
