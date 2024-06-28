package cyber.curso.resources;

import cyber.curso.domain.Usuario;
import cyber.curso.dto.UserDTO;
import cyber.curso.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserResource {
  
  @Autowired
  private UserService service;
  
  @GetMapping("/user")
  public ResponseEntity<List<UserDTO>> busatTodos() {
    List<Usuario> list = service.findAll();
    List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
    return ResponseEntity.ok().body(listDto);
  }
}