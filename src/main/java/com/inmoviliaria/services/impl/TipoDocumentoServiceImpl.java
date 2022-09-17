package com.inmoviliaria.services.impl;

import com.inmoviliaria.model.TipoDocumento;
import com.inmoviliaria.repository.TipoDocumentoRepository;
import com.inmoviliaria.services.TipoDocumentoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public TipoDocumento registrar(TipoDocumento obj) {
        return tipoDocumentoRepository.save(obj);
    }

    @Override
    public TipoDocumento modificar(TipoDocumento obj) {
        Optional<TipoDocumento> findTipDocument = tipoDocumentoRepository.findById(obj.getId());
        if(findTipDocument.isPresent()){
            TipoDocumento retTipDocument = findTipDocument.get();
            BeanUtils.copyProperties(obj,retTipDocument);
            return tipoDocumentoRepository.save(retTipDocument);
        }
        return null;
    }

    @Override
    public List<TipoDocumento> listar() {
        return tipoDocumentoRepository.findAll();
    }

    @Override
    public TipoDocumento listarPorId(Long id) {
        Optional<TipoDocumento> tipDocument = tipoDocumentoRepository.findById(id);
        return tipDocument.isPresent() ? tipDocument.get() : new TipoDocumento();
    }

    @Override
    public boolean eliminar(Long id) {
        return false;
    }
}
