package com.inmoviliaria.controllers;

import com.inmoviliaria.model.TipoDocumento;
import com.inmoviliaria.services.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tipodocumentos")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoService service;

    @GetMapping
    public ResponseEntity<List<TipoDocumento>> listar(){
        List<TipoDocumento> listTipoDocumento = service.listar();
        return new ResponseEntity<List<TipoDocumento>>(listTipoDocumento, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDocumento> buscar(@PathVariable("id") Long id){
        TipoDocumento obj = service.listarPorId(id);
        return new ResponseEntity<TipoDocumento>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@RequestBody TipoDocumento obj){
        TipoDocumento objTipoDocumento = service.registrar(obj);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objTipoDocumento.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public TipoDocumento modificar(@PathVariable("id") Long id,@RequestBody TipoDocumento obj){
        obj.setId(id);
        return service.modificar(obj);
    }
}
