package stats.analyzer.service;


import id.kanygin.stats.avro.EventSimilarityAvro;
import stats.analyzer.entity.EventSimilarity;

public interface EventSimilarityService {

    EventSimilarity save(EventSimilarityAvro eventSimilarityAvro);

}
