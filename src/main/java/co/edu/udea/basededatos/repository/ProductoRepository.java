package co.edu.udea.basededatos.repository;

import co.edu.udea.basededatos.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Optional<Producto> findByNombre(String nombre);

    List<Producto> getAllByFkAdministrador(Long fkAdministrator);
}
