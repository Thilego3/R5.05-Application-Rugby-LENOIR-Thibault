package application_rugby.tp1.controller;

import application_rugby.tp1.dto.MatchRequest;
import application_rugby.tp1.entities.Match;
import application_rugby.tp1.service.MatchService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController 
@RequestMapping("/matchs")

public class ControllerMatch {
    
    private final MatchService service;

    public ControllerMatch(MatchService service) {
        this.service = service;
    }

    // GET /matchs
    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Match> matchs = service.getAll();

        if (matchs.isEmpty()) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Aucun match trouvé");
        }

        return ResponseEntity.ok(matchs);
    }

    // GET /matchs?id={id}
    @GetMapping(params = "id")
    public ResponseEntity<?> getById(@RequestParam int id) {

        if (id <= 0) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("L'id doit être un entier positif");
        }

        Optional<Match> match = service.getById(id);

        if (match.isEmpty()) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Aucun match trouvé pour cette id");
        }

        return ResponseEntity.ok(match.get());
    }

    // POST /matchs
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody MatchRequest request) {
        if (!checkRequest(request)) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Requête invalide");
        }

        Match match = service.insert(request);
        return ResponseEntity.ok(match);
    }

    // Put /matchs?id={id}
    @PutMapping(params = "id")
    public ResponseEntity<?> update(
            @RequestParam int id,
            @RequestBody MatchRequest request) {

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

        Optional<Match> match = service.update(id, request);

        if (match.isEmpty()) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Aucun match trouvé pour cette id");
        }

        return ResponseEntity.ok(match.get());
    }

    // DELETE /matchs?id={id}
    @DeleteMapping(params = "id")
    public ResponseEntity<?> delete(@RequestParam int id) {

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

        return ResponseEntity.ok("Match supprimé avec succès");
    }

    // Patch /matchs/resultat?id={id}&resultat={resultat}
    @PatchMapping(path = "/resultat", params = {"id", "resultat"})
    public ResponseEntity<?> setResultat(
            @RequestParam int id,
            @RequestParam int resultat) {

        if (id <= 0) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("L'id doit être un entier positif");
        }

        Optional<Match> match = service.updateResultat(id, resultat);

        if (match.isEmpty()) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Aucun match trouvé pour cette id");
        }

        return ResponseEntity.ok(match.get());
    }
    

    // Check of the request format
    private boolean checkRequest(MatchRequest request) {
        if (request == null) {return false;}

        if (request.getDate() == null || request.getDate() == "") {return false;}
        if (request.getHeure() == null || request.getHeure() == "") {return false;}
        if (request.getNomEquipeAdverse() == null || request.getNomEquipeAdverse() == "") {return false;}
        if (request.getLieuDeRencontre() == null || request.getLieuDeRencontre() == "") {return false;}
        if (request.getIsDomicile() != 0 && request.getIsDomicile() != 1) {return false;}
        return true;
    }

}
