package co.edu.udea.basededatos.service;

import co.edu.udea.basededatos.entity.Producto;
import co.edu.udea.basededatos.entity.Usuario;
import co.edu.udea.basededatos.exception.BusinessException;
import co.edu.udea.basededatos.repository.ProductoRepository;
import co.edu.udea.basededatos.util.Messages;
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
