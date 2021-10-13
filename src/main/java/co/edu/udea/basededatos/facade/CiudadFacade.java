package co.edu.udea.basededatos.facade;

import co.edu.udea.basededatos.mapper.CiudadMapper;
import co.edu.udea.basededatos.modelo.CiudadDTO;
import co.edu.udea.basededatos.service.CiudadService;
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
