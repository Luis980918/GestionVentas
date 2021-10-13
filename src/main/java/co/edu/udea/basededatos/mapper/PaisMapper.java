package co.edu.udea.basededatos.mapper;

import co.edu.udea.basededatos.config.EntityMapper;
import co.edu.udea.basededatos.entity.Pais;
import co.edu.udea.basededatos.modelo.PaisDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaisMapper extends EntityMapper<PaisDTO, Pais> {
}
