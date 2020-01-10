package com.app.demo.Servicios;

import com.anal.app.Entidades.Consulta;

import java.util.List;

public interface IConsultaServicios {

    List<Consulta> findAll();

    Consulta saveOrUpdate(Consulta consulta);

}
