package stats.analyzer.service.mapper;


import id.kanygin.stats.avro.EventSimilarityAvro;
import stats.analyzer.entity.EventSimilarity;

public interface EventSimilarityMapper {

    EventSimilarity toEventSimilarity(EventSimilarityAvro eventSimilarityAvro);
}
