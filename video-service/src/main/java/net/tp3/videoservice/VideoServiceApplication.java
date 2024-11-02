package net.tp3.videoservice;

import net.tp3.videoservice.Dao.entities.Creator;
import net.tp3.videoservice.Dao.entities.Video;
import net.tp3.videoservice.Dao.repository.CreatorRepository;
import net.tp3.videoservice.Dao.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VideoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoServiceApplication.class, args);
    }
    @Autowired
    private CreatorRepository creatorRepository;

    @Autowired
    private VideoRepository videoRepository;

    @Bean
    CommandLineRunner start() {
        return args -> {

            List<Creator> creators = List.of(
                    Creator.builder().name("T").email("Te@gmail.com").build(),
                    Creator.builder().name("b").email("Be@gmail.com").build()
            );
            creatorRepository.saveAll(creators);

            List<Video> videos = List.of(
                    Video.builder()
                            .name("Vd 1")
                            .url("https://www.youtube.com/Video 1")
                            .description("Video 1")
                            .datePublication("25/09/2023")
                            .creator(creators.get(0))
                            .build(),

                    Video.builder()
                            .name("Vd 2")
                            .url("https://www.youtube.com/Video 2")
                            .description("Video 2")
                            .datePublication("16/10/2022")
                            .creator(creators.get(1))
                            .build());

            videoRepository.saveAll(videos);
        };
    }
}

