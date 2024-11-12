package net.tp3.videoservice.Dao.repository;

import net.tp3.videoservice.Dao.entities.Creator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CreatorRepository extends JpaRepository<Creator, Long> {

    Optional<Creator> findByEmail(String creatorEmail);
}
