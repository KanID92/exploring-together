package stats.analyzer.service.mapper;

import id.kanygin.stats.avro.EventSimilarityAvro;
import org.springframework.stereotype.Component;
import stats.analyzer.entity.EventSimilarity;

@Component
public class GeneralEventSimilarityMapper implements EventSimilarityMapper {

    @Override
    public EventSimilarity toEventSimilarity(EventSimilarityAvro eventSimilarityAvro) {
        return EventSimilarity.builder()
                .eventAId(eventSimilarityAvro.getEventA())
                .eventBId(eventSimilarityAvro.getEventB())
                .score(eventSimilarityAvro.getScore())
                .timestamp(eventSimilarityAvro.getTimestamp())
                .build();
    }
}
