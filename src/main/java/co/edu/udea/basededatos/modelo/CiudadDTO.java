package co.edu.udea.basededatos.modelo;

import javax.validation.constraints.NotNull;

public class CiudadDTO {

    private Long id;
    @NotNull
    private String nombre;
    private String nombreCorto;
    @NotNull
    private Boolean habilitado;
    @NotNull
    private Long fkDepartamento;
    private DepartamentoDTO departamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Long getFkDepartamento() {
        return fkDepartamento;
    }

    public void setFkDepartamento(Long fkDepartamento) {
        this.fkDepartamento = fkDepartamento;
    }

    public DepartamentoDTO getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoDTO departamento) {
        this.departamento = departamento;
    }
}
