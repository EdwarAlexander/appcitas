package com.inmoviliaria.services.impl;

import com.inmoviliaria.model.Cita;
import com.inmoviliaria.repository.CitaRepository;
import com.inmoviliaria.services.CitaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CitaServiceImpl implements CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Override
    public Cita registrar(Cita obj) {
        return citaRepository.save(obj);
    }

    @Override
    public Cita modificar(Cita obj) {
        Optional<Cita> findCit = citaRepository.findById(obj.getId());
        if(findCit.isPresent()){
            Cita retCita = findCit.get();
            BeanUtils.copyProperties(obj,retCita);
            return citaRepository.save(retCita);
        }
        return null;
    }

    @Override
    public List<Cita> listar() {
        return citaRepository.findAll();
    }

    @Override
    public Cita listarPorId(Long id) {
        Optional<Cita> cit = citaRepository.findById(id);
        return cit.isPresent() ? cit.get() : new Cita();
    }

    @Override
    public boolean eliminar(Long id) {
        return false;
    }
}
