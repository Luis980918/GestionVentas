package co.edu.udea.fundamentos.service;

import co.edu.udea.fundamentos.entity.Producto;
import co.edu.udea.fundamentos.exception.BusinessException;
import co.edu.udea.fundamentos.repository.ProductoRepository;
import co.edu.udea.fundamentos.util.Messages;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final Messages messages;

    public ProductoService(ProductoRepository productoRepository, Messages messages){
        this.productoRepository=productoRepository;
        this.messages=messages;
    }

    public Producto guardarProducto(Producto producto) {
        Optional<Producto> productoConsulta = productoRepository.findByNombre(producto.getNombre());
        if(productoConsulta.isPresent()){
            throw new BusinessException(messages.get("producto.nombre.duplicado"));
        }
        return productoRepository.save(producto);
    }

    public Producto actualizarProducto(Producto producto) {
        if (Objects.isNull(producto.getId())) {
            throw new BusinessException(messages.get("producto.id.vacio"));
        }
        consultarPorId(producto.getId());
        return productoRepository.save(producto);
    }

    public void eliminarProducto(Long id) {
        consultarPorId(id);
        productoRepository.deleteById(id);
    }

    public Producto consultarPorId(Long id) {
        return productoRepository.findById(id).orElseThrow(
                () -> new BusinessException(messages.get("producto.id.no_encontrado")));
    }

    public List<Producto> buscarTodos(Long adminClave) {
        return productoRepository.getAllByFkAdministrador(adminClave);
    }
}
