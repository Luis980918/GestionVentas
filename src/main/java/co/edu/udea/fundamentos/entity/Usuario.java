package co.edu.udea.fundamentos.entity;

import co.edu.udea.fundamentos.util.enums.TipoUsuario;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "correo", nullable = false, length = 100, unique = true)
    private String correo;

    @Column(name = "contrasena", length = 50)
    private String contrasena;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "celular")
    private String celular;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private TipoUsuario tipo;

    //Vendedor

    @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso;

    @Column(name = "fk_ciudad_vendedor")
    private Long fkCiudadvendedor;

    @Column(name = "fk_administrador")
    private Long fkAdministrador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_ciudad_vendedor", insertable = false, updatable = false)
    private Ciudad ciudadvendedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_administrador", insertable = false, updatable = false)
    private Usuario administrador;

    //Administrador

    @Column(name = "nombre_empresa", length = 200)
    private String nombreEmpresa;

    @Column(name = "fk_ciudad_administrador")
    private Long fkCiudadAdministrador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_ciudad_administrador", insertable = false, updatable = false)
    private Ciudad ciudadAdministrador;

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

    public Long getFkCiudadvendedor() {
        return fkCiudadvendedor;
    }

    public void setFkCiudadvendedor(Long fkCiudadvendedor) {
        this.fkCiudadvendedor = fkCiudadvendedor;
    }

    public Long getFkAdministrador() {
        return fkAdministrador;
    }

    public void setFkAdministrador(Long fkAdministrador) {
        this.fkAdministrador = fkAdministrador;
    }

    public Ciudad getCiudadvendedor() {
        return ciudadvendedor;
    }

    public void setCiudadvendedor(Ciudad ciudadvendedor) {
        this.ciudadvendedor = ciudadvendedor;
    }

    public Usuario getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Usuario administrador) {
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

    public Ciudad getCiudadAdministrador() {
        return ciudadAdministrador;
    }

    public void setCiudadAdministrador(Ciudad ciudadAdministrador) {
        this.ciudadAdministrador = ciudadAdministrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
