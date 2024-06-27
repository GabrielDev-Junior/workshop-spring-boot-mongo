package cyber.curso.resources;

import cyber.curso.domain.Usuario;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserResource {
  
  @GetMapping("/user")
  public ResponseEntity<List<Usuario>> busatTodos() {
    Usuario maria = new Usuario("1", "Maria", "maria@gmail.com");
    Usuario lucas = new Usuario("2", "Lucas", "lucas@gmail.com");
    Usuario marcelo = new Usuario("3", "Marcelo", "marcelo@gmail.com");
    List<Usuario> list = new ArrayList<>(Arrays.asList(maria, lucas, marcelo));
    return ResponseEntity.ok().body(list);
  }
}