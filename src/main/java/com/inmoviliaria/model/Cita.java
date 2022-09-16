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
}
