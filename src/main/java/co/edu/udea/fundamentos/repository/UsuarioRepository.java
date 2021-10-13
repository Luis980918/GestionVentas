package co.edu.udea.fundamentos.repository;

import co.edu.udea.fundamentos.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCorreo(String correo);

    @Query("SELECT usuario FROM Usuario usuario WHERE " +
            "usuario.fkAdministrador = :idAdministrador AND " +
            "(:nombre IS NULL OR UPPER(usuario.nombre) LIKE (%:nombre%)) AND " +
            "(:correo IS NULL OR usuario.correo = :correo) ")
    Page<Usuario> buscarUsuarioPorAdmin(
            @Param("idAdministrador") Long idAdministrador,
            @Param("nombre") String nombre,
            @Param("correo") String correo,
            Pageable page
    );


}
