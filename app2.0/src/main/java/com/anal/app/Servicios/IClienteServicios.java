package com.app.demo.Servicios;

import com.anal.app.Entidades.Cliente;

import java.util.List;

public interface IClienteServicios {

    List<Cliente> findAll();

    Cliente saveOrUpdate(Cliente cliente);

  
}
