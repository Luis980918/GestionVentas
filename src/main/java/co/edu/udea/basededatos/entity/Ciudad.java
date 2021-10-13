package co.edu.udea.basededatos.entity;

import javax.persistence.*;

@Entity
@Table(name = "ciudad")
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "nombre_corto", length = 5)
    private String nombreCorto;

    @Column(name = "habilitado", nullable = false)
    private Boolean habilitado;

    @Column(name = "fk_departamento", nullable = false)
    private Long fkDepartamento;

    // relationships

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_departamento", insertable = false, updatable = false)
    private Departamento departamento;

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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
