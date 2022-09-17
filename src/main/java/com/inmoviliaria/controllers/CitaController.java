package com.inmoviliaria.controllers;

import com.inmoviliaria.model.Cita;
import com.inmoviliaria.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaService service;

    @GetMapping
    public ResponseEntity<List<Cita>> listar(){
        List<Cita> list = service.listar();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscar(@PathVariable("id") Long id){
        Cita obj = service.listarPorId(id);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@RequestBody Cita obj){
        Cita objSave = service.registrar(obj);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(objSave.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public Cita modificar(@PathVariable("id") Long id,@RequestBody Cita obj){
        obj.setId(id);
        return service.modificar(obj);
    }
}
