package com.inmoviliaria.services.impl;

import com.inmoviliaria.model.Cliente;
import com.inmoviliaria.repository.ClienteRepository;
import com.inmoviliaria.services.ClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente registrar(Cliente obj) {
        return clienteRepository.save(obj);
    }

    @Override
    public Cliente modificar(Cliente obj) {
        Optional<Cliente> findClient = clienteRepository.findById(obj.getId());
        if(findClient.isPresent()){
            Cliente retClient = findClient.get();
            BeanUtils.copyProperties(obj,retClient);
            return clienteRepository.save(retClient);
        }
        return null;
    }

    @Override
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente listarPorId(Long id) {
        Optional<Cliente> client = clienteRepository.findById(id);
        return client.isPresent() ? client.get() : new Cliente();
    }

    @Override
    public boolean eliminar(Long id) {
        return false;
    }
}
