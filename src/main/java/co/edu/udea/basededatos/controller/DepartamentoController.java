package co.edu.udea.basededatos.controller;


import co.edu.udea.basededatos.exception.DataNotFoundException;
import co.edu.udea.basededatos.facade.DepartamentoFacade;
import co.edu.udea.basededatos.modelo.DepartamentoDTO;
import co.edu.udea.basededatos.util.Messages;
import co.edu.udea.basededatos.util.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
    private final DepartamentoFacade departamentoFacade;
    private final Messages messages;

    public DepartamentoController(DepartamentoFacade departamentoFacade, Messages messages) {
        this.departamentoFacade = departamentoFacade;
        this.messages = messages;
    }

    @PostMapping
    @ApiOperation(value = "Permite crear un departamento", response = DepartamentoDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se guardó exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<DepartamentoDTO>> guardarDepartamento(@Valid @RequestBody DepartamentoDTO departamento) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("departamento.guardar.exito"), departamentoFacade.guardarDepartamento(departamento)));

    }

    @PutMapping
    @ApiOperation(value = "Permite actualizar un departamento", response = DepartamentoDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se actualizó el departamento exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<DepartamentoDTO>> actualizarDepartamento(@Valid @RequestBody DepartamentoDTO departamento) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("departamento.actualizatr.exito"), departamentoFacade.actualizarDepartamento(departamento)));
    }

    @DeleteMapping("/{codigoDepartamento}")
    @ApiOperation(value = "Permite eliminar un departamento")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "El departamento se eliminó exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<Void>> eliminarDepartamento(@PathVariable Long codigoDepartamento) {
        try {
            departamentoFacade.eliminarDepartamento(codigoDepartamento);
            return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("departamento.eliminar.exito")));
        } catch (DataIntegrityViolationException e) {
            throw new DataNotFoundException(messages.get("departamento.eliminar.error"));
        }
    }

    @GetMapping("/{codigoDepartamento}")
    @ApiOperation(value = "Permite buscar un departamento", response = DepartamentoDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "El departamento se consultó correctamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<DepartamentoDTO>> consultarPorId(@PathVariable Long codigoDepartamento) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, departamentoFacade.consultarPorId(codigoDepartamento)));
    }

    @GetMapping
    @ApiOperation(value = "Permite buscar todos los departamentos", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Los departamentos se consultaron correctamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<List<DepartamentoDTO>>> buscarTodos() {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, departamentoFacade.buscarTodos()));
    }
}
