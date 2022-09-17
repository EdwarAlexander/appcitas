package com.inmoviliaria.model;

import javax.persistence.*;

@Entity
@Table( name = "cita")
public class Cita {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "idcliente")
    @ManyToOne
    private Cliente cliente;

    @JoinColumn(name = "idvendedor")
    @ManyToOne
    private Vendedor vendedor;

    public Cita() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}
