package co.edu.udea.fundamentos.facade;

import co.edu.udea.fundamentos.mapper.ProductoMapper;
import co.edu.udea.fundamentos.modelo.ProductoDTO;
import co.edu.udea.fundamentos.service.ProductoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductoFacade {

    private final ProductoService productoService;
    private final ProductoMapper productoMapper;

    public ProductoFacade(ProductoService productoService, ProductoMapper productoMapper){
        this.productoMapper=productoMapper;
        this.productoService=productoService;
    }

    public ProductoDTO guardarProducto(ProductoDTO producto){
        return productoMapper.toDto(productoService.guardarProducto(productoMapper.toEntity(producto)));
    }

    public ProductoDTO actualizarProducto(ProductoDTO producto){
        return productoMapper.toDto(productoService.actualizarProducto(productoMapper.toEntity(producto)));
    }

    public void eliminarProducto(Long id){
        productoService.eliminarProducto(id);
    }

    public ProductoDTO consultarPorId(Long id){
        return productoMapper.toDto(productoService.consultarPorId(id));
    }

    public List<ProductoDTO> buscarTodos(Long adminClave) {
        return productoMapper.toDto(productoService.buscarTodos(adminClave));
    }


}
