package co.edu.udea.fundamentos.facade;

import co.edu.udea.fundamentos.mapper.CiudadMapper;
import co.edu.udea.fundamentos.modelo.CiudadDTO;
import co.edu.udea.fundamentos.service.CiudadService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CiudadFacade {

    private final CiudadService ciudadService;
    private final CiudadMapper ciudadMapper;

    public CiudadFacade(CiudadService ciudadService, CiudadMapper ciudadMapper){
        this.ciudadService=ciudadService;
        this.ciudadMapper=ciudadMapper;
    }

    public CiudadDTO guardarCiudad(CiudadDTO ciudad){
        return ciudadMapper.toDto(ciudadService.guardarCiudad(ciudadMapper.toEntity(ciudad)));
    }

    public CiudadDTO actualizarCiudad(CiudadDTO ciudad){
        return ciudadMapper.toDto(ciudadService.actualizarCiudad(ciudadMapper.toEntity(ciudad)));
    }

    public void eliminarCiudad(Long id){
        ciudadService.eliminarCiudad(id);
    }

    public CiudadDTO consultarPorId(Long id){
        return ciudadMapper.toDto(ciudadService.consultarPorId(id));
    }

    public List<CiudadDTO> buscarTodas(){
        return ciudadMapper.toDto(ciudadService.buscarTodas());
    }
}
