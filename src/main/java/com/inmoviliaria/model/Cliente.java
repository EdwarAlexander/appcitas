package com.inmoviliaria.model;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 180)
    private String nombre;

    @Column(length = 180)
    private String apellido;

    @Column(length = 20)
    private String nroDocumento;

    @ManyToOne
    @JoinColumn(name = "idtipodocumento")
    private TipoDocumento tipoDocumento;
}
