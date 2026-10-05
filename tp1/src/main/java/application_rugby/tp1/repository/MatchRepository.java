package application_rugby.tp1.repository;

import application_rugby.tp1.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Integer> {
}