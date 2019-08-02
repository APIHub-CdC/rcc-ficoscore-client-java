

package io.apihub.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;


import io.apihub.client.model.Consulta;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "io.apihub.codegen.languages.JavaClientCodegen", date = "2019-08-01T16:44:21.339Z")
public class Consultas {
  @SerializedName("consultas")
  private List<Consulta> consultas = null;
  public Consultas consultas(List<Consulta> consultas) {
    this.consultas = consultas;
    return this;
  }
  public Consultas addConsultasItem(Consulta consultasItem) {
    if (this.consultas == null) {
      this.consultas = new ArrayList<Consulta>();
    }
    this.consultas.add(consultasItem);
    return this;
  }
   
  public List<Consulta> getConsultas() {
    return consultas;
  }
  public void setConsultas(List<Consulta> consultas) {
    this.consultas = consultas;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Consultas consultas = (Consultas) o;
    return Objects.equals(this.consultas, consultas.consultas);
  }
  @Override
  public int hashCode() {
    return Objects.hash(consultas);
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Consultas {\n");
    
    sb.append("    consultas: ").append(toIndentedString(consultas)).append("\n");
    sb.append("}");
    return sb.toString();
  }
  
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
