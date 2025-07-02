package br.edu.imepac.comum.services;

import br.edu.imepac.comum.dtos.prontuario.ProntuarioDto;
import br.edu.imepac.comum.dtos.prontuario.ProntuarioRequest;
import br.edu.imepac.comum.exceptions.NotFoundClinicaMedicaException;
import br.edu.imepac.comum.models.Consulta;
import br.edu.imepac.comum.models.Prontuario;
import br.edu.imepac.comum.repositories.ConsultaRepository;
import br.edu.imepac.comum.repositories.ProntuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProntuarioService {
    private final ConsultaRepository consultaRepository;

    private final ModelMapper modelMapper;

    private final ProntuarioRepository prontuarioRepository;


    public ProntuarioService(ModelMapper modelMapper, ProntuarioRepository prontuarioRepository,
                             ConsultaRepository consultaRepository) {
        this.modelMapper = modelMapper;
        this.prontuarioRepository = prontuarioRepository;
        this.consultaRepository = consultaRepository;
    }

    public ProntuarioDto adicionarProntuario(ProntuarioRequest prontuarioRequest) {
//        log.info("Cadastro de prontuário - service: {}", prontuarioRequest);
//        Prontuario prontuario = modelMapper.map(prontuarioRequest, Prontuario.class);
//        prontuario = prontuarioRepository.save(prontuario);
//        return modelMapper.map(prontuario, ProntuarioDto.class);
        log.info("Cadastro de prontuário - service: {}", prontuarioRequest);
        Consulta consulta = consultaRepository.findById(prontuarioRequest.getConsultaId())
                .orElseThrow(() -> new NotFoundClinicaMedicaException("Consulta não encontrado com ID: " + prontuarioRequest.getConsultaId()));
        if (consulta.getProntuario() != null) {
            throw new IllegalArgumentException("Consulta já possui prontuário");
        }
        Prontuario prontuario = Prontuario.builder()
                .receituario(prontuarioRequest.getReceituario())
                .exames(prontuarioRequest.getExames())
                .observacoes(prontuarioRequest.getObservacoes())
                .consulta(consulta)
                .build();
        prontuario = prontuarioRepository.save(prontuario);
        return modelMapper.map(prontuario, ProntuarioDto.class);
    }

    public ProntuarioDto atualizarProntuario(Long id, ProntuarioDto prontuarioDto) {
        log.info("Atualizando prontuário com ID: {}", id);
        Prontuario prontuarioExistente = prontuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundClinicaMedicaException("Prontuário não encontrado com ID: " + id));
        modelMapper.map(prontuarioDto, prontuarioExistente);
        Prontuario prontuarioAtualizado = prontuarioRepository.save(prontuarioExistente);
        return modelMapper.map(prontuarioAtualizado, ProntuarioDto.class);
    }

    public void removerProntuario(Long id) {
        log.info("Removendo prontuário com ID: {}", id);
        Prontuario prontuario = prontuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundClinicaMedicaException("Prontuário não encontrado com ID: " + id));
        prontuarioRepository.delete(prontuario);
    }

    public ProntuarioDto buscarProntuarioPorId(Long id) {
        log.info("Buscando prontuário com ID: {}", id);
        Prontuario prontuario = prontuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundClinicaMedicaException("Prontuário não encontrado com ID: " + id));
        return modelMapper.map(prontuario, ProntuarioDto.class);
    }

    public List<ProntuarioDto> listarProntuarios() {
        log.info("Listando todos os prontuários");
        List<Prontuario> prontuarios = prontuarioRepository.findAll();
        return prontuarios.stream()
                .map(prontuario -> modelMapper.map(prontuario, ProntuarioDto.class))
                .toList();
    }
}

