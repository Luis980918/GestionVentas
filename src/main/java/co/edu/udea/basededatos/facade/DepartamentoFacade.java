package co.edu.udea.basededatos.facade;

import co.edu.udea.basededatos.mapper.DepartamentoMapper;
import co.edu.udea.basededatos.modelo.DepartamentoDTO;
import co.edu.udea.basededatos.service.DepartamentoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartamentoFacade {
    private final DepartamentoService departamentoService;
    private final DepartamentoMapper departamentoMapper;

    public DepartamentoFacade(DepartamentoService departamentoService, DepartamentoMapper departamentoMapper) {
        this.departamentoService = departamentoService;
        this.departamentoMapper = departamentoMapper;
    }

    public DepartamentoDTO guardarDepartamento(DepartamentoDTO departamento) {
        return departamentoMapper.toDto(departamentoService.guardarDepartamento(departamentoMapper.toEntity(departamento)));
    }

    public DepartamentoDTO actualizarDepartamento(DepartamentoDTO departamento) {
        return departamentoMapper.toDto(departamentoService.actualizarDepartamento(departamentoMapper.toEntity(departamento)));
    }

    public void eliminarDepartamento(Long id) {
        departamentoService.eliminarDepartamento(id);
    }

    public DepartamentoDTO consultarPorId(Long id) {
        return departamentoMapper.toDto(departamentoService.consultarPorId(id));
    }

    public List<DepartamentoDTO> buscarTodos() {
        return departamentoMapper.toDto(departamentoService.buscarTodos());
    }
}
