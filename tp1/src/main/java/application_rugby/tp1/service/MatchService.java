package application_rugby.tp1.service;

import application_rugby.tp1.repository.MatchRepository;
import application_rugby.tp1.entities.Match;
import application_rugby.tp1.dto.MatchRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    private final MatchRepository repository;

    public MatchService(MatchRepository repository) {
        this.repository = repository;
    }

    // GET all match
    public List<Match> getAll() {
        return repository.findAll();
    }

    // GET match by id
    public Optional<Match> getById(int id) {
        return repository.findById(id);
    }

    // POST match
    public Match insert(MatchRequest request) {
        // Set properties of match based on request
        Match match = new Match();
        match.setDate(request.getDate());
        match.setHeure(request.getHeure());
        match.setNomEquipeAdverse(request.getNomEquipeAdverse());
        match.setLieuDeRencontre(request.getLieuDeRencontre());
        match.setIsDomicile(request.getIsDomicile());

        return repository.save(match);
    }

    // PUT match
    public Optional<Match> update(int id, MatchRequest request) {
        Optional<Match> optionalMatch = repository.findById(id);
        
        if (optionalMatch.isEmpty()) {
            return Optional.empty();
        }

        Match match = optionalMatch.get();
        // Set properties of match based on request
        match.setDate(request.getDate());
        match.setHeure(request.getHeure());
        match.setNomEquipeAdverse(request.getNomEquipeAdverse());
        match.setLieuDeRencontre(request.getLieuDeRencontre());
        match.setIsDomicile(request.getIsDomicile());

        return Optional.of(repository.save(match));
    }

    // DELETE match
    public boolean delete(int id) {
        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }

    // PATCH resultat match
    public Optional<Match> updateResultat(int id, int resultat) {
        Optional<Match> optionalMatch = repository.findById(id);
        
        if (optionalMatch.isEmpty()) {
            return Optional.empty();
        }

        Match match = optionalMatch.get();
        match.setResultat(resultat);

        return Optional.of(repository.save(match));
    } 
}
