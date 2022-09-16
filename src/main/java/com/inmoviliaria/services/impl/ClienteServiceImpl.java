package com.inmoviliaria.services.impl;

import com.inmoviliaria.model.Cliente;
import com.inmoviliaria.services.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Override
    public Cliente registrar(Cliente obj) {
        return null;
    }

    @Override
    public Cliente modificar(Cliente obj) {
        return null;
    }

    @Override
    public List<Cliente> listar() {
        return null;
    }

    @Override
    public Cliente listarPorId(Long id) {
        return null;
    }

    @Override
    public boolean eliminar(Long id) {
        return false;
    }
}
