package br.edu.imepac.comum.services;

import br.edu.imepac.comum.dtos.paciente.PacienteDto;
import br.edu.imepac.comum.dtos.paciente.PacienteRequest;
import br.edu.imepac.comum.models.Paciente;
import br.edu.imepac.comum.repositories.PacienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PacienteService {

    private final ModelMapper modelMapper;
    private final PacienteRepository repository;

    public PacienteService(ModelMapper modelMapper, PacienteRepository repository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    public PacienteDto adicionarPaciente(PacienteRequest request) {
        log.info("Cadastro de paciente: {}", request);
        Paciente paciente = modelMapper.map(request, Paciente.class);
        paciente = repository.save(paciente);
        return modelMapper.map(paciente, PacienteDto.class);
    }

    public PacienteDto atualizarPaciente(Long id, PacienteDto dto) {
        log.info("Atualizando paciente com ID: {}", id);
        Paciente existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado com ID: " + id));
        modelMapper.map(dto, existente);
        Paciente atualizado = repository.save(existente);
        return modelMapper.map(atualizado, PacienteDto.class);
    }

    public void removerPaciente(Long id) {
        log.info("Removendo paciente com ID: {}", id);
        Paciente paciente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado com ID: " + id));
        repository.delete(paciente);
    }

    public PacienteDto buscarPorId(Long id) {
        log.info("Buscando paciente com ID: {}", id);
        Paciente paciente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado com ID: " + id));
        return modelMapper.map(paciente, PacienteDto.class);
    }

    public List<PacienteDto> listar() {
        log.info("Listando todos os pacientes");
        return repository.findAll().stream()
                .map(p -> modelMapper.map(p, PacienteDto.class))
                .toList();
    }
}
