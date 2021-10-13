package co.edu.udea.basededatos.mapper;

import co.edu.udea.basededatos.config.EntityMapper;
import co.edu.udea.basededatos.entity.Usuario;
import co.edu.udea.basededatos.modelo.UsuarioDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CiudadMapper.class})
public interface UsuarioMapper extends EntityMapper<UsuarioDTO, Usuario> {
}
