package co.edu.udea.fundamentos.mapper;

import co.edu.udea.fundamentos.config.EntityMapper;
import co.edu.udea.fundamentos.entity.Usuario;
import co.edu.udea.fundamentos.modelo.UsuarioDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CiudadMapper.class})
public interface UsuarioMapper extends EntityMapper<UsuarioDTO, Usuario> {
}
