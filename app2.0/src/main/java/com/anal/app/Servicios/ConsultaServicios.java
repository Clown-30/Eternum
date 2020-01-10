package com.anal.app.Servicios;

import com.anal.app.Entidades.Consulta;
import com.anal.app.Repositorios.ConsultaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaServicios implements IConsultaServicios{
    @Autowired
    private ConsultaRepositorio repositorio;


    public List<Consulta> findAll() {
        List<Consulta> consulta = (List<Consulta>) repositorio.findAll();
        return consulta;
    }


    public Consulta obtenerporId(int id){
        return repositorio.findById(id);
    }


    public Consulta saveOrUpdate(Consulta consulta) {
        repositorio.save(consulta);
        return consulta;
    }

  
    public void delete(int id) {
        repositorio.deleteById(id);
    }




}
