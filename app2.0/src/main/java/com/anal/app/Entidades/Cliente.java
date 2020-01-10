
package com.anal.app.Entidades;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
@Entity
@Table(name = "clientes")
public class Cliente{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id_cliente;
  String nombre;
  String password;



  public Cliente() {
  }

  public Cliente(int id_cliente,String nombre, String password) {
      this.id_cliente = id_cliente;
      this.nombre = nombre;
      this.password = password;
  }


  public int getId_cliente() {
      return id_cliente;
  }

  public String getPassword() {
      return password;
  }

  public String getNombre() {
      return nombre;
  }

  public void setPassword(String password) {
      this.password = password;
  }

  public void setNombre(String nombre) {
      this.nombre = nombre;
  }

  @Override
  public int hashCode() {
      int hash = 7;
      hash = 79 * hash + Objects.hashCode(this.id_cliente);
      hash = 79 * hash + Objects.hashCode(this.nombre);
      hash = 79 * hash + Objects.hashCode(this.password);
      return hash;
  }

  @Override
  public boolean equals(Object obj) {
      if (this == obj) {
          return true;
      }
      if (obj == null) {
          return false;
      }
      if (getClass() != obj.getClass()) {
          return false;
      }
      final Cliente other = (Cliente) obj;
      if (!Objects.equals(this.nombre, other.nombre)) {
          return false;
      }
      if (!Objects.equals(this.password, other.password)) {
          return false;
      }
      return Objects.equals(this.id_cliente, other.id_cliente);
  }

  @Override
  public String toString() {
      final StringBuilder sb = new StringBuilder("Cliente{");
      sb.append("id_cliente=").append(id_cliente);
      sb.append(", nombre='").append(nombre).append('\'');
      sb.append(", password=").append(password);
      sb.append('}');
      return sb.toString();
  }





}
