package co.edu.udea.basededatos.mapper;

import co.edu.udea.basededatos.config.EntityMapper;
import co.edu.udea.basededatos.entity.Departamento;
import co.edu.udea.basededatos.modelo.DepartamentoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PaisMapper.class})
public interface DepartamentoMapper extends EntityMapper<DepartamentoDTO, Departamento> {
}
