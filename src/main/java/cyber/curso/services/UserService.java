package cyber.curso.services;

import cyber.curso.domain.Usuario;
import cyber.curso.dto.UserDTO;
import cyber.curso.repository.UserRepository;
import cyber.curso.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  
  @Autowired
  private UserRepository repository;
  
  public List<Usuario> findAll(){
    return repository.findAll();
  }
  
  public Usuario findById(String id){
    Optional<Usuario> user = repository.findById(id);
    if(user.isEmpty()){
      throw new ObjectNotFoundException("Usuario não encontrado");
    }
    return user.get();
  }
  
  public Usuario insert(Usuario obj){
    return repository.insert(obj);
  }
  
  public void delete(String id){
    findById(id);
    repository.deleteById(id);
  }
  
  public Usuario update(Usuario obj){
    Usuario novo = repository.findById(obj.getId()).orElse(null);
    if(novo == null){
      throw new ObjectNotFoundException("Usuario não encontrado");
    }
    updateData(novo,obj);
    return repository.save(novo);
  }
  
  private void updateData(Usuario novoUsuario, Usuario obj) {
    novoUsuario.setName(obj.getName());
    novoUsuario.setEmail(obj.getEmail());
  }
  
  public Usuario fromDTO(UserDTO objDto){
    return new Usuario(objDto.getId(), objDto.getName(), objDto.getEmail());
  }
}
