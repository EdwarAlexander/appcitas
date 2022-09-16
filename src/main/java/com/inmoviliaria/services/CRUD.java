package com.inmoviliaria.services;

import java.util.List;

public interface CRUD<T,V> {

    T registrar(T obj);

    T modificar(T obj);

    List<T> listar();

    T listarPorId(V id);

    boolean eliminar(V id);
}
