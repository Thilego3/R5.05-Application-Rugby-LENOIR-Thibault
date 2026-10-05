package application_rugby.tp1.controller;

import application_rugby.tp1.dto.JoueurRequest;
import application_rugby.tp1.entities.Joueur;
import application_rugby.tp1.service.JoueurService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
                .status(HttpStatus.NOT_FOUND)
                .body("Aucun joueur trouvé");
        }

        return ResponseEntity.ok(joueurs);
    }

    // GET /joueurs/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        try {
            int idInt = Integer.parseInt(id);

            if (idInt <= 0) {
                return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("L'id doit être un entier positif");
            }

            Optional<Joueur> joueur = service.getById(idInt);

            if (joueur.isEmpty()) {
                return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Aucun joueur trouvé pour cette id");
            }

            return ResponseEntity.ok(joueur.get());

        } catch (NumberFormatException e) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("L'id doit être un entier positif");
        }
    }
/*
    // POST /joueurs
    @PostMapping("")
    public ResponseEntity<?> insert(@RequestBody JoueurRequest request) {
        if (!checkRequest(request)) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Requête invalide");
        }

        Joueur joueur = service.insert(request);
        return ResponseEntity.ok(joueur);
    }

    // Put /joueurs/{id}
    @PutMapping("/{idString}")
    public ResponseEntity<?> update(
            @PathVariable String idString,
            @RequestBody JoueurRequest request) {
        try {
            int id = Integer.parseInt(idString);

            if (id <= 0) {
                return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("L'id doit être un entier positif");
            }

            if (!checkRequest(request)) {
                return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Requête invalide");
            }

            Optional<Joueur> joueur = service.update(id, request);

            if (joueur.isEmpty()) {
                return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Aucun joueur trouvé pour cette id");
            }

            return ResponseEntity.ok(joueur.get());


        } catch (NumberFormatException e) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("L'id doit être un entier positif");
        }
    }
    
    // DELETE /joueurs/{id}
    @DeleteMapping("/{idString}")
    public ResponseEntity<?> delete(@PathVariable String idString) {
        try {
            int id = Integer.parseInt(idString);

            if (id <= 0) {
                return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("L'id doit être un entier positif");
            }
            
            boolean deleted = service.delete(id);

            if (!deleted) {
                return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Aucun joueur trouvé pour cette id");
            }

            return ResponseEntity.ok("Joueur supprimé avec succès");

        } catch (NumberFormatException e) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("L'id doit être un entier positif");
        }
    }

    // Check of the request format

    private boolean checkRequest(JoueurRequest request) {
        if (request == null) {return false;}

        if (request.getNumLicence() <= 0) {return false;}
        if (request.getTaille() <= 0) {return false;}
        if (request.getPoids() <= 0) {return false;}

        if (request.getNom() == null || request.getNom() == "") {return false;}
        if (request.getPrenom() == null || request.getPrenom() == "") {return false;}
        if (request.getDateDeNaissance() == null || request.getDateDeNaissance() == "") {return false;}
        if (request.getStatut() == null || request.getStatut() == "") {return false;}
        
        if (request.getStatut() == "Actif" 
                || request.getStatut() == "Blessé"
                || request.getStatut() == "Suspendu"
                || request.getStatut() == "Absent" ){
            return true;
        }
        return false;
    }*/

}
