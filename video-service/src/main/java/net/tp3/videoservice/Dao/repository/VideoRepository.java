package net.tp3.videoservice.Dao.repository;

import net.tp3.videoservice.Dao.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
