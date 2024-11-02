package net.tp3.videoservice.Dao.repository;

import net.tp3.videoservice.Dao.entities.Creator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreatorRepository extends JpaRepository<Creator, Long> {

}
