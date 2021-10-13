package co.edu.udea.fundamentos.entity;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name= "transporte")
public class Transporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="placa", nullable=false, length= 10)
    private String placa;

    @Column(name="fk_tipo_transporte", nullable=false)
    private Long fkTipoTransporte;

    //relationships

    @ManyToOne
    @JoinColumn(name="fk_tipo_transporte", insertable = false, updatable = false)
    private TipoTransporte tipoTransporte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Long getFkTipoTransporte() {
        return fkTipoTransporte;
    }

    public void setFkTipoTransporte(Long fkTipoTransporte) {
        this.fkTipoTransporte = fkTipoTransporte;
    }

    public TipoTransporte getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(TipoTransporte tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }
}
