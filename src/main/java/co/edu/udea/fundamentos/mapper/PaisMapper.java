package co.edu.udea.fundamentos.mapper;

import co.edu.udea.fundamentos.config.EntityMapper;
import co.edu.udea.fundamentos.entity.Pais;
import co.edu.udea.fundamentos.modelo.PaisDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaisMapper extends EntityMapper<PaisDTO, Pais> {
}
