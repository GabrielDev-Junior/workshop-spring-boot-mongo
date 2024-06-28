package cyber.curso.config;

import cyber.curso.domain.Usuario;
import cyber.curso.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
  
  @Autowired
  private UserRepository repository;
  
  @Override
  public void run(String... args) throws Exception {
    
    repository.deleteAll();
    
    Usuario marcos = new Usuario(null,"Marcos","marcos@gmail.com");
    Usuario maria = new Usuario(null,"Maria","maria@gmail.com");
    Usuario joao = new Usuario(null,"João","joao@gmail.com");
    Usuario teresa = new Usuario(null,"Teresa","teresa@gmail.com");
    
    repository.saveAll(Arrays.asList(marcos,maria,joao,teresa));
    
  }
}
