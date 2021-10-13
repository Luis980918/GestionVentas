package co.edu.udea.fundamentos.service;

import co.edu.udea.fundamentos.entity.Departamento;
import co.edu.udea.fundamentos.exception.BusinessException;
import co.edu.udea.fundamentos.repository.DepartamentoRepository;
import co.edu.udea.fundamentos.util.Messages;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class DepartamentoService {
    private final DepartamentoRepository departamentoRepository;
    private final Messages messages;

    public DepartamentoService(DepartamentoRepository departamentoRepository, Messages messages) {
        this.departamentoRepository = departamentoRepository;
        this.messages = messages;
    }

    public Departamento guardarDepartamento(Departamento departamento) {

        Optional<Departamento> paisConsulta = departamentoRepository.findByNombre(departamento.getNombre());
        if (paisConsulta.isPresent()) {
            throw new BusinessException(messages.get("departamento.nombre.duplicado"));
        }
        return departamentoRepository.save(departamento);
    }

    public Departamento actualizarDepartamento(Departamento departamento) {
        if (Objects.isNull(departamento.getId())) {
            throw new BusinessException(messages.get("departamento.id.vacio"));
        }
        consultarPorId(departamento.getId());
        return departamentoRepository.save(departamento);
    }


    public void eliminarDepartamento(Long id) {
        consultarPorId(id);
        departamentoRepository.deleteById(id);
    }

    public Departamento consultarPorId(Long id) {
        return departamentoRepository.findById(id).orElseThrow(
                () -> new BusinessException(messages.get("departamento.id.no_encontrado")));
    }

    public List<Departamento> buscarTodos() {
        return departamentoRepository.findAll();
    }
}
