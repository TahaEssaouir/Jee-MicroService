package net.tp3.videoservice.Dao.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor @NoArgsConstructor @Builder
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String url;
    private String description;
    private String datePublication;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Creator creator;
}
