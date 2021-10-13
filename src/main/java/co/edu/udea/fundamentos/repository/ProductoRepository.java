package co.edu.udea.fundamentos.repository;

import co.edu.udea.fundamentos.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Optional<Producto> findByNombre(String nombre);

    List<Producto> getAllByFkAdministrador(Long fkAdministrator);
}
