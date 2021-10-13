package co.edu.udea.fundamentos.entity;

import co.edu.udea.fundamentos.util.enums.EstadoCompraEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="valor_total", nullable=false)
    private BigDecimal valorTotal;

    @Column(name="cantidad", nullable = false)
    private Integer cantidad;

    @Column(name="fecha_venta", nullable=false)
    private LocalDate fechaVenta;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoCompraEnum estado;

    @Column(name="fk_cliente", nullable=false)
    private Long fkCliente;

    @Column(name="fk_producto", nullable=false)
    private Long fkProducto;

    // relationships

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_cliente", insertable = false, updatable = false)
    private Usuario cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_producto", insertable = false, updatable = false)
    private Producto producto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public EstadoCompraEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoCompraEnum estado) {
        this.estado = estado;
    }

    public Long getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(Long fkCliente) {
        this.fkCliente = fkCliente;
    }

    public Long getFkProducto() {
        return fkProducto;
    }

    public void setFkProducto(Long fkProducto) {
        this.fkProducto = fkProducto;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
