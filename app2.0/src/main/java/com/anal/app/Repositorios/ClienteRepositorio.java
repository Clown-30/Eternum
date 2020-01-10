package com.anal.app.Repositorios;
import com.anal.app.Entidades.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.io.Serializable;
import java.util.List;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer>{
  public abstract Cliente findById(int id);

  public abstract List<Cliente> findAll();
}
