package co.edu.udea.fundamentos.mapper;

import co.edu.udea.fundamentos.config.EntityMapper;
import co.edu.udea.fundamentos.entity.Producto;
import co.edu.udea.fundamentos.modelo.ProductoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses={UsuarioMapper.class})
public interface ProductoMapper extends EntityMapper<ProductoDTO, Producto> {
}
