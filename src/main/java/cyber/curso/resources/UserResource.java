package cyber.curso.resources;

import cyber.curso.domain.Usuario;
import cyber.curso.dto.UserDTO;
import cyber.curso.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "users")
public class UserResource {
  
  @Autowired
  private UserService service;
  
  @GetMapping
  public ResponseEntity<List<UserDTO>> busatTodos() {
    List<Usuario> list = service.findAll();
    List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
    return ResponseEntity.ok().body(listDto);
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<UserDTO> findById(@PathVariable String id) {
    Usuario user = service.findById(id);
    return ResponseEntity.ok().body(new UserDTO(user));
  }
}