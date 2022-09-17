package com.inmoviliaria.controllers;

import com.inmoviliaria.model.Vendedor;
import com.inmoviliaria.services.VendedorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {

    @Autowired
    private VendedorService service;

    @GetMapping
    public ResponseEntity<List<Vendedor>> listar(){
        List<Vendedor> list = service.listar();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscar(@PathVariable("id") Long id){
        Vendedor obj = service.listarPorId(id);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@RequestBody Vendedor obj){
        Vendedor objSave = service.registrar(obj);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(objSave.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public Vendedor modificar(@PathVariable("id") Long id,@RequestBody Vendedor obj){
        obj.setId(id);
        return service.modificar(obj);
    }
}
