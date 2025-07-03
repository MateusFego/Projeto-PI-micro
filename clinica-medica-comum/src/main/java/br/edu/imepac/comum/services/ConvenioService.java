package br.edu.imepac.comum.services;

import br.edu.imepac.comum.dtos.convenio.ConvenioDto;
import br.edu.imepac.comum.dtos.convenio.ConvenioRequest;
import br.edu.imepac.comum.exceptions.NotFoundClinicaMedicaException;
import br.edu.imepac.comum.models.Consulta;
import br.edu.imepac.comum.models.Convenio;
import br.edu.imepac.comum.repositories.ConsultaRepository;
import br.edu.imepac.comum.repositories.ConvenioRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ConvenioService {

    private final ModelMapper modelMapper;
    private final ConvenioRepository repository;
    ConsultaRepository consultaRepository;

    public ConvenioService(ModelMapper modelMapper, ConvenioRepository repository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    public ConvenioDto adicionarConvenio(ConvenioRequest request) {
        log.info("Cadastro de convênio: {}", request);
//        Convenio c = modelMapper.map(request, Convenio.class);
        Convenio c = Convenio.builder()
                .nome(request.getNome())
                .descricao(request.getDescricao())
                .build();
        c = repository.save(c);
        return modelMapper.map(c, ConvenioDto.class);
    }

    public ConvenioDto atualizarConvenio(Long id, ConvenioDto dto) {
        log.info("Atualizando convênio com ID: {}", id);
        Convenio existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Convênio não encontrado com ID: " + id));
        modelMapper.map(dto, existente);
        Convenio atualizado = repository.save(existente);
        return modelMapper.map(atualizado, ConvenioDto.class);
    }

    public void removerConvenio(Long id) {
        log.info("Removendo convênio com ID: {}", id);
        Convenio c = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Convênio não encontrado com ID: " + id));
        repository.delete(c);
    }

    public ConvenioDto buscarConvenioPorId(Long id) {
        log.info("Buscando convênio com ID: {}", id);
        Convenio c = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Convênio não encontrado com ID: " + id));
        return modelMapper.map(c, ConvenioDto.class);
    }

    public List<ConvenioDto> listarConvenios() {
        log.info("Listando todos os convênios");
        return repository.findAll().stream()
                .map(c -> modelMapper.map(c, ConvenioDto.class))
                .toList();
    }
}
