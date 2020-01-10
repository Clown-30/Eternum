package com.anal.app.Repositorios;
import com.anal.app.Entidades.Consulta;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.io.Serializable;
import java.util.List;

@Repository
public interface ConsultaRepositorio extends JpaRepository<Consulta, Integer>{
  public abstract Consulta findById(int id);
  public abstract List<Consulta> findAll();
}
