package cyber.curso.resources;

import cyber.curso.domain.Usuario;
import cyber.curso.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserResource {
  
  @Autowired
  private UserService service;
  
  @GetMapping("/user")
  public ResponseEntity<List<Usuario>> busatTodos() {
    List<Usuario> list = service.findAll();
    return ResponseEntity.ok().body(list);
  }
}