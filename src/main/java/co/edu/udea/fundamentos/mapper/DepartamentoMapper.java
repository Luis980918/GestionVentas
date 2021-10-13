package co.edu.udea.fundamentos.mapper;

import co.edu.udea.fundamentos.config.EntityMapper;
import co.edu.udea.fundamentos.entity.Departamento;
import co.edu.udea.fundamentos.modelo.DepartamentoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PaisMapper.class})
public interface DepartamentoMapper extends EntityMapper<DepartamentoDTO, Departamento> {
}
