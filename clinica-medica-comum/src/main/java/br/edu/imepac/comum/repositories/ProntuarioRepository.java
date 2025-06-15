package br.edu.imepac.comum.repositories;
import br.edu.imepac.comum.models.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProntuarioRepository extends JpaRepository<Prontuario, Integer> {}
