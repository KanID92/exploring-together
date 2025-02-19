package core.like.controller;

import core.like.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PrivateLikeController {

    private final LikeService likeService;


    @PutMapping("/users/{userId}/events/{eventId}/likes")
    public Long addEventLike(@PathVariable long userId, @PathVariable long eventId) {
        return likeService.addEventLike(eventId, userId);
    }

    @DeleteMapping("/users/{userId}/events/{eventId}/likes")
    public Long deleteEventLike(@PathVariable long userId, @PathVariable long eventId) {
        return likeService.deleteEventLike(eventId, userId);
    }

    @PutMapping("/users/{userId}/locations/{locationId}/likes")
    public Long addLocationLike(@PathVariable long userId, @PathVariable long locationId) {
        return likeService.addLocationLike(locationId, userId);
    }

    @DeleteMapping("/users/{userId}/locations/{locationId}/likes")
    public Long deleteLocationLike(@PathVariable long userId, @PathVariable long locationId) {
        return likeService.deleteLocationLike(locationId, userId);
    }






}
