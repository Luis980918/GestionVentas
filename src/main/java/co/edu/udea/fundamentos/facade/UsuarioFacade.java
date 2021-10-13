package co.edu.udea.fundamentos.facade;

import co.edu.udea.fundamentos.mapper.UsuarioMapper;
import co.edu.udea.fundamentos.modelo.UsuarioDTO;
import co.edu.udea.fundamentos.service.UsuarioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioFacade {

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    public UsuarioFacade(UsuarioService usuarioService, UsuarioMapper usuarioMapper) {
        this.usuarioService = usuarioService;
        this.usuarioMapper = usuarioMapper;
    }

    public UsuarioDTO guardarUsuario(UsuarioDTO usuario) {
        return usuarioMapper.toDto(usuarioService.guardarUsuario(usuarioMapper.toEntity(usuario)));
    }

    public UsuarioDTO actualizarUsuario(UsuarioDTO usuario) {
        return usuarioMapper.toDto(usuarioService.actualizarUsuario(usuarioMapper.toEntity(usuario)));
    }

    public void eliminarUsuario(Long id) {
        usuarioService.eliminarUsuario(id);
    }

    public UsuarioDTO consultarPorId(Long id) {
        return usuarioMapper.toDto(usuarioService.consultarPorId(id));
    }

    public UsuarioDTO buscarUsuarioPorCorreo(String correo, String contrasena) {
        return usuarioMapper.toDto(usuarioService.buscarUsuarioPorCorreo(correo, contrasena));
    }

    public Page<UsuarioDTO> buscarUsuarioPorAdmin(Long idAdministrador, String nombre, String correo, Pageable page) {
        return usuarioService.buscarUsuarioPorAdmin(idAdministrador, nombre, correo, page).map(usuarioMapper::toDto);
    }

}
