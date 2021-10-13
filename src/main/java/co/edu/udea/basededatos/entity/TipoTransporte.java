package co.edu.udea.basededatos.entity;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "tipo_transporte")
public class TipoTransporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nombre", nullable=false)
    private String nombre;

    @Column(name="fk_administrador", nullable=false)
    private Long fkAdministrador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_administrador", insertable = false, updatable = false)
    private Usuario usuario;

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

    public Long getFkAdministrador() {
        return fkAdministrador;
    }

    public void setFkAdministrador(Long fkAdministrador) {
        this.fkAdministrador = fkAdministrador;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
