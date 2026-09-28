package application_rugby.tp1.repository;

import application_rugby.tp1.entities.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoueurRepository extends JpaRepository<Joueur, Integer> {
}