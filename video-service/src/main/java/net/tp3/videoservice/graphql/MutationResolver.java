package net.tp3.videoservice.graphql;

import net.tp3.videoservice.Dao.entities.Creator;
import net.tp3.videoservice.Dao.entities.Video;
import net.tp3.videoservice.Dao.repository.CreatorRepository;
import net.tp3.videoservice.Dao.repository.VideoRepository;
import net.tp3.videoservice.dto.CreatorRequest;
import net.tp3.videoservice.dto.VideoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MutationResolver {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private CreatorRepository creatorRepository;

    @MutationMapping
    public Video saveVideo(@Argument VideoRequest videoRequest) {
        // Check if a creator with the given email already exists
        Creator creator = creatorRepository.findByEmail(videoRequest.getCreatorEmail())
                .orElseGet(() -> {
                    // If not, create a new creator
                    Creator newCreator = Creator.builder()
                            .name(videoRequest.getCreatorName())
                            .email(videoRequest.getCreatorEmail())
                            .build();
                    return creatorRepository.save(newCreator);
                });

        // Create and save the new video
        Video newVideo = Video.builder()
                .name(videoRequest.getName())
                .url(videoRequest.getUrl())
                .description(videoRequest.getDescription())
                .datePublication(videoRequest.getDatePublication())
                .creator(creator)
                .build();

        return videoRepository.save(newVideo);
    }
    @MutationMapping
    public Creator saveCreator(@Argument CreatorRequest creatorRequest) {
        // Convert CreatorRequest to Creator entity
        Creator creator = Creator.builder()
                .name(creatorRequest.getName())
                .email(creatorRequest.getEmail())
                .build();

        // Save the creator to the repository
        return creatorRepository.save(creator);
    }
}