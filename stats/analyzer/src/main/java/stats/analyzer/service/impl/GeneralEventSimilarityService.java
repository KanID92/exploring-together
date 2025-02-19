package stats.analyzer.service.impl;

import id.kanygin.stats.avro.EventSimilarityAvro;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import stats.analyzer.entity.EventSimilarity;
import stats.analyzer.repository.EventSimilarityRepository;
import stats.analyzer.service.EventSimilarityService;
import stats.analyzer.service.mapper.EventSimilarityMapper;

@Service
@RequiredArgsConstructor
public class GeneralEventSimilarityService implements EventSimilarityService {

    private final EventSimilarityRepository eventSimilarityRepository;
    private final EventSimilarityMapper eventSimilarityMapper;

    @Override
    public EventSimilarity save(EventSimilarityAvro eventSimilarityAvro) {
        return eventSimilarityRepository.save(
                eventSimilarityMapper.toEventSimilarity(eventSimilarityAvro));
    }

}
