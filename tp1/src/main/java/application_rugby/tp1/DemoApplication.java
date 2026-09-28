package application_rugby.tp1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import application_rugby.tp1.repository.JoueurRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "application_rugby.tp1.repository")
@RestController
public class DemoApplication {

  @Autowired
  private JoueurRepository joueurRepository;

    public static void main(String[] args) {
      SpringApplication.run(DemoApplication.class, args);
    }
    @GetMapping("/bonjour")
    public String hello(@RequestParam(defaultValue = "World") String name) {
      return joueurRepository.findById(3)
          .map(joueur -> "Hello " + joueur.getNom() + "!")
          .orElse("Joueur not found");
    }
}
