package com.inmoviliaria.services.impl;

import com.inmoviliaria.model.Vendedor;
import com.inmoviliaria.services.VendedorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorServiceImpl implements VendedorService {
    @Override
    public Vendedor registrar(Vendedor obj) {
        return null;
    }

    @Override
    public Vendedor modificar(Vendedor obj) {
        return null;
    }

    @Override
    public List<Vendedor> listar() {
        return null;
    }

    @Override
    public Vendedor listarPorId(Long id) {
        return null;
    }

    @Override
    public boolean eliminar(Long id) {
        return false;
    }
}
