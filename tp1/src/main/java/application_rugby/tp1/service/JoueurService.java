package application_rugby.tp1.service;

import application_rugby.tp1.repository.JoueurRepository;
import application_rugby.tp1.entities.Joueur;
import application_rugby.tp1.dto.JoueurRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class JoueurService {

    private final JoueurRepository repository;

    public JoueurService(JoueurRepository joueurRepository) {
        this.repository = joueurRepository;
    }

    // GET all joueur
    public List<Joueur> getAll() {
        return repository.findAll();
    }

    // GET joueur by id
    public Optional<Joueur> getById(int id) {
        return repository.findById(id);
    }

    // Post joueur
    public Joueur insert(JoueurRequest request) {
        // Set properties of joueur based on request
        Joueur joueur = new Joueur();
        joueur.setNumLicence(request.getNumLicence());
        joueur.setNom(request.getNom());
        joueur.setPrenom(request.getPrenom());
        joueur.setDateDeNaissance(request.getDateDeNaissance());
        joueur.setTaille(request.getTaille());
        joueur.setPoids(request.getPoids());
        joueur.setStatut(request.getStatut());

        return repository.save(joueur);
    }

    // PUT joueur
    public Optional<Joueur> update(int id, JoueurRequest request) {
        Optional<Joueur> optionalJoueur = repository.findById(id);
        
        if (optionalJoueur.isEmpty()) {
            return Optional.empty();
        }

        Joueur joueur = optionalJoueur.get();
        // Set properties of joueur based on request
        joueur.setNumLicence(request.getNumLicence());
        joueur.setNom(request.getNom());
        joueur.setPrenom(request.getPrenom());
        joueur.setDateDeNaissance(request.getDateDeNaissance());
        joueur.setTaille(request.getTaille());
        joueur.setPoids(request.getPoids());
        joueur.setStatut(request.getStatut());

        return Optional.of(repository.save(joueur));
    }

    // DELETE joueur
    public boolean delete(int id) {
        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }

}
