package cyber.curso.resources;

import cyber.curso.domain.Usuario;
import cyber.curso.dto.UserDTO;
import cyber.curso.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserResource {
  
  @Autowired
  private UserService service;
  
  @GetMapping("/users")
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
  
  @PostMapping
  public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
    Usuario user = service.fromDTO(objDto);
    user = service.insert(user);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id").buildAndExpand(user.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }
}