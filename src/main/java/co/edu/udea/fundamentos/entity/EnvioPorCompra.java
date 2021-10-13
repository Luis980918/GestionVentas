package co.edu.udea.fundamentos.entity;

import javax.persistence.*;

@Entity
@Table(name = "envio_por_compra")
public class EnvioPorCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="fk_envio", nullable=false)
    private Long fkEnvio;

    @Column(name="fk_compra", nullable=false)
    private Long fkCompra;

    // relationships

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_envio", insertable = false, updatable = false)
    private Envio envio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_compra", insertable = false, updatable = false)
    private Compra compra;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFkEnvio() {
        return fkEnvio;
    }

    public void setFkEnvio(Long fkEnvio) {
        this.fkEnvio = fkEnvio;
    }

    public Long getFkCompra() {
        return fkCompra;
    }

    public void setFkCompra(Long fkCompra) {
        this.fkCompra = fkCompra;
    }

    public Envio getEnvio() {
        return envio;
    }

    public void setEnvio(Envio envio) {
        this.envio = envio;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
}
