package cyber.curso.services;

import cyber.curso.domain.Usuario;
import cyber.curso.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  
  @Autowired
  private UserRepository repository;
  
  public List<Usuario> findAll(){
    return repository.findAll();
  }
}
