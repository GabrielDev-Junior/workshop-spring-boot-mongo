package cyber.curso.domain;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Usuario implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;
  
  private String id;
  private String name;
  private String email;
  
  public Usuario() {
  }
  
  public Usuario(String id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }
  
  public String getId() {
    return id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Usuario usuario = (Usuario) o;
    return Objects.equals(id, usuario.id);
  }
  
  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
  
  @Override
  public String toString() {
    return "Usuario(a) : " + id + ", " + name + ", " + email;
  }
}
