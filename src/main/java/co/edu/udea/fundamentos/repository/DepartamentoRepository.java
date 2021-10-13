package co.edu.udea.fundamentos.repository;

import co.edu.udea.fundamentos.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    Optional<Departamento> findByNombre(String nombnre);
}
