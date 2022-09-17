package com.inmoviliaria.services.impl;

import com.inmoviliaria.model.Vendedor;
import com.inmoviliaria.repository.VendedorRepository;
import com.inmoviliaria.services.VendedorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorServiceImpl implements VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Override
    public Vendedor registrar(Vendedor obj) {
        return vendedorRepository.save(obj);
    }

    @Override
    public Vendedor modificar(Vendedor obj) {
        Optional<Vendedor> findVendedor = vendedorRepository.findById(obj.getId());
        if(findVendedor.isPresent()){
            Vendedor retVendedor = findVendedor.get();
            BeanUtils.copyProperties(obj, retVendedor);
            return vendedorRepository.save(retVendedor);
        }
        return null;
    }

    @Override
    public List<Vendedor> listar() {
        return vendedorRepository.findAll();
    }

    @Override
    public Vendedor listarPorId(Long id) {
        Optional<Vendedor> vendedor = vendedorRepository.findById(id);
        return vendedor.isPresent() ? vendedor.get() : new Vendedor();
    }

    @Override
    public boolean eliminar(Long id) {
        return false;
    }
}
