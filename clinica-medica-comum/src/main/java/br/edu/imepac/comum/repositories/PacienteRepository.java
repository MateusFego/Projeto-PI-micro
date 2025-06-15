package br.edu.imepac.comum.repositories;
import br.edu.imepac.comum.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {}
