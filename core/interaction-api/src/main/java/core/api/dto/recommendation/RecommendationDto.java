package core.api.dto.recommendation;

public record RecommendationDto(
        long eventId,
        double score
) {
}
