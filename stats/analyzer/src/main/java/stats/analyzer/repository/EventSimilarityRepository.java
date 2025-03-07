package stats.analyzer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stats.analyzer.entity.EventSimilarity;

import java.util.List;

public interface EventSimilarityRepository extends JpaRepository<EventSimilarity, Long> {

    List<EventSimilarity> findAllByEventAIdOrEventBId(long eventA, long eventB);

}
