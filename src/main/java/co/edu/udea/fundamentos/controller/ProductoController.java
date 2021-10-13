package co.edu.udea.fundamentos.controller;

import co.edu.udea.fundamentos.exception.DataNotFoundException;
import co.edu.udea.fundamentos.facade.ProductoFacade;
import co.edu.udea.fundamentos.modelo.ProductoDTO;
import co.edu.udea.fundamentos.util.Messages;
import co.edu.udea.fundamentos.util.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoFacade productoFacade;
    private final Messages messages;

    public ProductoController(ProductoFacade productoFacade, Messages messages){
        this.productoFacade=productoFacade;
        this.messages=messages;
    }

    @PostMapping
    @ApiOperation(value = "Permite crear un producto", response = ProductoDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se guardó el producto exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<ProductoDTO>> guardarProducto(@Valid @RequestBody ProductoDTO producto) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("producto.guardar.exito"), productoFacade.guardarProducto(producto)));
    }

    @PutMapping
    @ApiOperation(value = "Permite actualizar un producto", response = ProductoDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se actualizó el producto exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<ProductoDTO>> actualizarProducto(@Valid @RequestBody ProductoDTO producto) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("producto.actualizar.exito"), productoFacade.actualizarProducto(producto)));
    }

    @DeleteMapping("/{codigoProducto}")
    @ApiOperation(value = "Permite eliminar un producto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "El producto se eliminó exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<Void>> eliminarProducto(@PathVariable Long codigoProducto) {
        try {
            productoFacade.eliminarProducto(codigoProducto);
            return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("producto.eliminar.exito")));
        } catch (DataIntegrityViolationException e) {
            throw new DataNotFoundException(messages.get("producto.eliminar.error"));
        }
    }

    @GetMapping("/{codigoProducto}")
    @ApiOperation(value = "Permite buscar un producto", response = ProductoDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "El producto se consultó correctamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<ProductoDTO>> consultarPorId(@PathVariable Long codigoProducto) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, productoFacade.consultarPorId(codigoProducto)));
    }

    @GetMapping("buscar-todos/{codigoAdmin}")
    @ApiOperation(value = "Permite buscar todos los productos dentro del inventario", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "El producto se consultó correctamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<List<ProductoDTO>>> buscarTodos(@PathVariable Long codigoAdmin) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, productoFacade.buscarTodos(codigoAdmin)));
    }

}
