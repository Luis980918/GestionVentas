package co.edu.udea.basededatos.mapper;

import co.edu.udea.basededatos.config.EntityMapper;
import co.edu.udea.basededatos.entity.Ciudad;
import co.edu.udea.basededatos.modelo.CiudadDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {DepartamentoMapper.class})
public interface CiudadMapper extends EntityMapper<CiudadDTO, Ciudad> {
}
