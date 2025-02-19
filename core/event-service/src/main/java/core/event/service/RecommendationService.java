package core.event.service;

import core.api.dto.recommendation.RecommendationDto;

import java.util.List;

public interface RecommendationService {

    List<RecommendationDto> getRecommendations(long userId, int size);

}
