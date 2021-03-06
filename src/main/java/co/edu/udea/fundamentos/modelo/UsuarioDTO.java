package co.edu.udea.fundamentos.modelo;

import co.edu.udea.fundamentos.util.enums.TipoUsuario;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class UsuarioDTO {

    private Long id;
    @NotNull
    private String correo;
    private String contrasena;
    private LocalDate fechaNacimiento;
    private String celular;
    @NotNull
    private TipoUsuario tipo;
    private String nombre;

    //Vededor

    private LocalDate fechaIngreso;
    private Long fkCiudadVededor;
    private Long fkAdministrador;
    private CiudadDTO ciudadVendedor;
    private UsuarioDTO administrador;

    //Administrador

    private String nombreEmpresa;
    private Long fkCiudadAdministrador;
    private CiudadDTO ciudadAdministrador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Long getFkCiudadVendedor() {
        return fkCiudadVededor;
    }

    public void setFkCiudadVededor(Long fkCiudadVededor) {
        this.fkCiudadVededor = fkCiudadVededor;
    }

    public Long getFkAdministrador() {
        return fkAdministrador;
    }

    public void setFkAdministrador(Long fkAdministrador) {
        this.fkAdministrador = fkAdministrador;
    }

    public CiudadDTO getCiudadVendedor() {
        return ciudadVendedor;
    }

    public void setCiudadVendedor(CiudadDTO ciudadVendedor) {
        this.ciudadVendedor = ciudadVendedor;
    }

    public UsuarioDTO getAdministrador() {
        return administrador;
    }

    public void setAdministrador(UsuarioDTO administrador) {
        this.administrador = administrador;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public Long getFkCiudadAdministrador() {
        return fkCiudadAdministrador;
    }

    public void setFkCiudadAdministrador(Long fkCiudadAdministrador) {
        this.fkCiudadAdministrador = fkCiudadAdministrador;
    }

    public CiudadDTO getCiudadAdministrador() {
        return ciudadAdministrador;
    }

    public void setCiudadAdministrador(CiudadDTO ciudadAdministrador) {
        this.ciudadAdministrador = ciudadAdministrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
