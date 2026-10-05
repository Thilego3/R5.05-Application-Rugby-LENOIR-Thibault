package application_rugby.tp1.repository;

import application_rugby.tp1.entities.Joueurs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoueurRepository extends JpaRepository<Joueurs, Integer> {
}