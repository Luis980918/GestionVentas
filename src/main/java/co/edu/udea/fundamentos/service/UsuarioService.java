package co.edu.udea.fundamentos.service;

import co.edu.udea.fundamentos.entity.Usuario;
import co.edu.udea.fundamentos.exception.BusinessException;
import co.edu.udea.fundamentos.repository.UsuarioRepository;
import co.edu.udea.fundamentos.util.Messages;
import co.edu.udea.fundamentos.util.enums.TipoUsuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final Messages messages;

    public UsuarioService(UsuarioRepository usuarioRepository, Messages messages) {
        this.usuarioRepository = usuarioRepository;
        this.messages = messages;
    }

    public Usuario guardarUsuario(Usuario usuario) {
        Optional<Usuario> usuarioConsulta = usuarioRepository.findByCorreo(usuario.getCorreo());
        if (usuarioConsulta.isPresent()) {
            throw new BusinessException(messages.get("usuario.correo.duplicado"));
        }
        usuario.setFechaIngreso(LocalDate.now());
        validarTipo(usuario);
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizarUsuario(Usuario usuario) {
        if (Objects.isNull(usuario.getId())) {
            throw new BusinessException(messages.get("usuario.id.vacio"));
        }
        consultarPorId(usuario.getId());
        validarTipo(usuario);
        return usuarioRepository.save(usuario);
    }

    public void validarTipo(Usuario usuario) {
        if (usuario.getTipo().equals(TipoUsuario.VENDEDOR)) {
            if (Objects.isNull(usuario.getFechaIngreso()) ||
                    Objects.isNull(usuario.getFkCiudadvendedor()) || Objects.isNull(usuario.getFkAdministrador())) {
                throw new BusinessException(messages.get("usuario.informacion.incompleta"));
            }
        }
    }

    public void eliminarUsuario(Long id) {
        consultarPorId(id);
        usuarioRepository.deleteById(id);
    }

    public Usuario consultarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new BusinessException(messages.get("usuario.id.no_encontrado")));
    }

    public Usuario buscarUsuarioPorCorreo(String correo, String contrasena) {
        Usuario usuarioConsulta = usuarioRepository.findByCorreo(correo).orElseThrow(
                () -> new BusinessException(messages.get("usuario.correo.no_encontrado")));
        if (!usuarioConsulta.getContrasena().equals(contrasena)) {
            throw new BusinessException(messages.get("usuario.contrasena.no_valida"));
        }
        return usuarioConsulta;
    }

    public Page<Usuario> buscarUsuarioPorAdmin(Long idAdministrador, String nombre, String correo, Pageable page) {
        return usuarioRepository.buscarUsuarioPorAdmin(idAdministrador, nombre != null ? nombre.toUpperCase().trim() : null, correo != null ? correo.trim() : null, page);
    }

}
