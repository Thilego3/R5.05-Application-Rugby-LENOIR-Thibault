package application_rugby.tp1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import application_rugby.tp1.repository.JoueurRepository;
import application_rugby.tp1.repository.MatchRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "application_rugby.tp1.repository")
@RestController
public class DemoApplication {

  @Autowired
  private JoueurRepository joueurRepository;

  @Autowired
  private MatchRepository matchRepository;

    public static void main(String[] args) {
      SpringApplication.run(DemoApplication.class, args);
    }
    @GetMapping("/joueur")
    public String joueur(@RequestParam(defaultValue = "joueur") String param) {
      return joueurRepository.findById(3)
          .map(joueur -> "Joueur: " + joueur.getNom())
          .orElse("Joueur not found");
    }
    @GetMapping("/match")
    public String match(@RequestParam(defaultValue = "match") String param) {
        return matchRepository.findById(4)
          .map(match -> "Match: " + match.getNomEquipeAdverse())
          .orElse("Match not found");
    }
    
}
