package com.anal.app.Servicios;

import com.anal.app.Entidades.Cliente;
import com.anal.app.Repositorios.ClienteRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServicios implements IClienteServicios{
    @Autowired
    private ClienteRepositorio repositorio;

    @Override
    public List<Cliente> findAll() {
        List<Cliente> cliente = (List<Cliente>) repositorio.findAll();
        return cliente;
    }

    public Cliente obtenerporId(int id){
        return repositorio.findById(id);
    }

    @Override
    public Cliente saveOrUpdate(Cliente cliente) {
        repositorio.save(cliente);
        return cliente;
    }

    public void delete(int id) {
        repositorio.deleteById(id);
    }


}
