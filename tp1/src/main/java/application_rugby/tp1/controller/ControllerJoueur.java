package application_rugby.tp1.controller;

import application_rugby.tp1.entities.Joueur;
import application_rugby.tp1.service.JoueurService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/joueurs")

public class ControllerJoueur {
    
    private final JoueurService service;

    public ControllerJoueur(JoueurService service) {
        this.service = service;
    }

    // GET /joueurs
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        List<Joueur> joueurs = service.getAll();

        if (joueurs.isEmpty()) {
            return ResponseEntity
                .status(404)
                .body("Aucun joueur trouvé");
        }

        return ResponseEntity.ok(joueurs);
    }

    // GET /joueurs/{id}
    @GetMapping("/{idString}")
    public ResponseEntity<?> getById(@PathVariable String idString) {
        try {
            int id = Integer.parseInt(idString);

            if (id <= 0) {
                return ResponseEntity
                    .status(400)
                    .body("L'id doit être un entier positif");
            }

            Optional<Joueur> joueur = service.getById(id);

            if (joueur.isEmpty()) {
                return ResponseEntity
                    .status(404)
                    .body("Aucun joueur trouvé pour cette id");
            }

            return ResponseEntity.ok(joueur.get());

        } catch (NumberFormatException e) {
            return ResponseEntity
                .status(400)
                .body("L'id doit être un entier positif");
        }
    }

}
