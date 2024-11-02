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

            List<Creator> creators = List.of(Creator.builder().name("x").email("Te@gmail.com")
                    .build());
            creatorRepository.saveAll(creators);

            List<Video> videos = List.of(Video.builder()
                    .name("AYOUB EL KAABI - \uD83C\uDDF2\uD83C\uDDE6⚽\uFE0F قصة كفاح البطل أيوب الكعبي")
                    .url("https://www.youtube.com")
                    .description("Follow me on instagram : tahaessou")
                    .datePublication("28/09/2002")
                    .creator(creators.get(0))
                            .build());

            videoRepository.saveAll(videos);
};
    }

}

