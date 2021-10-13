package co.edu.udea.basededatos.mapper;

import co.edu.udea.basededatos.config.EntityMapper;
import co.edu.udea.basededatos.entity.Producto;
import co.edu.udea.basededatos.modelo.ProductoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses={UsuarioMapper.class})
public interface ProductoMapper extends EntityMapper<ProductoDTO, Producto> {
}
