
package com.anal.app.Entidades;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
@Entity
@Table(name = "consultas")
public class Consulta{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id_consulta;
  int id_cliente;
  String asunto;
  String texto;

  public Consulta(){

  }


  public Consulta(int id_cliente){
    this.id_cliente = id_cliente;
  }

  public Consulta(int id_consulta, int id_cliente,String asunto,String texto) {
      this.id_consulta = id_consulta;
      this.id_cliente = id_cliente;
      this.texto = texto;
      this.asunto = asunto;
  }

  public int getId_consulta() {
      return id_consulta;
  }

  public String getTexto() {
      return texto;
  }

  public int getId_cliente(){
    return id_cliente;
  }

  public String getAsunto() {
      return asunto;
  }

  public void setTexto(String texto) {
      this.texto = texto;
  }

  public void setAsunto(String asunto) {
      this.asunto = asunto;
  }

  public void setId_cliente(int id_cliente) {
      this.id_cliente = id_cliente;
  }

  @Override
  public int hashCode() {
      int hash = 7;
      hash = 79 * hash + Objects.hashCode(this.id_consulta);
      hash = 79 * hash + Objects.hashCode(this.id_cliente);
      hash = 79 * hash + Objects.hashCode(this.asunto);
      hash = 79 * hash + Objects.hashCode(this.texto);
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
      final Consulta other = (Consulta) obj;
      if (!Objects.equals(this.asunto, other.asunto)) {
          return false;
      }
      if (!Objects.equals(this.texto, other.texto)) {
          return false;
      }
      if (!Objects.equals(this.id_cliente, other.id_cliente)) {
          return false;
      }
      return Objects.equals(this.id_consulta, other.id_consulta);
  }

  @Override
  public String toString() {
      final StringBuilder sb = new StringBuilder("Consulta{");
      sb.append("id_consulta=").append(id_consulta);
      sb.append("id_cliente=").append(id_cliente);
      sb.append(", asunto='").append(asunto).append('\'');
      sb.append(", texto=").append(texto);
      sb.append('}');
      return sb.toString();
  }





}
