package co.edu.udea.basededatos.entity;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "envio")
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fk_transporte", nullable = false)
    private Long fkTransporte;

    @Column(name = "fk_ciudad_destino", nullable = false)
    private Long fkCiudadDestino;

    @Column(name = "fk_ciudad_origen", nullable = false)
    private Long fkCiudadOrigen;


    // relationships

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_transporte", insertable = false, updatable = false)
    private Transporte transporte;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_ciudad_destino", insertable = false, updatable = false)
    private Ciudad ciudadDestino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_ciudad_origen", insertable = false, updatable = false)
    private Ciudad ciudadOrigen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFkTransporte() {
        return fkTransporte;
    }

    public void setFkTransporte(Long fkTransporte) {
        this.fkTransporte = fkTransporte;
    }

    public Long getFkCiudadDestino() {
        return fkCiudadDestino;
    }

    public void setFkCiudadDestino(Long fkCiudadDestino) {
        this.fkCiudadDestino = fkCiudadDestino;
    }

    public Long getFkCiudadOrigen() {
        return fkCiudadOrigen;
    }

    public void setFkCiudadOrigen(Long fkCiudadOrigen) {
        this.fkCiudadOrigen = fkCiudadOrigen;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public Ciudad getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(Ciudad ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public Ciudad getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(Ciudad ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }
}
