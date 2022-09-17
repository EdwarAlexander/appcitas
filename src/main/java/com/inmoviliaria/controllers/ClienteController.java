package com.inmoviliaria.controllers;

import com.inmoviliaria.model.Cliente;
import com.inmoviliaria.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<Cliente>> listar(){
        List<Cliente> list = service.listar();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscar(@PathVariable("id") Long id){
        Cliente obj = service.listarPorId(id);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@RequestBody Cliente obj){
        Cliente objSave = service.registrar(obj);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(objSave.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public Cliente modificar(@PathVariable("id") Long id,@RequestBody Cliente obj){
        obj.setId(id);
        return service.modificar(obj);
    }
}
