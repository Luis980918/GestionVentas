package co.edu.udea.fundamentos.mapper;

import co.edu.udea.fundamentos.config.EntityMapper;
import co.edu.udea.fundamentos.entity.Ciudad;
import co.edu.udea.fundamentos.modelo.CiudadDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {DepartamentoMapper.class})
public interface CiudadMapper extends EntityMapper<CiudadDTO, Ciudad> {
}
