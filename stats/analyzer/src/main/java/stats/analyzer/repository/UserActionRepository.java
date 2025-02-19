package stats.analyzer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stats.analyzer.entity.UserAction;

import java.util.List;

public interface UserActionRepository extends JpaRepository<UserAction, Long> {

    List<UserAction> getUserActionsByUserId(long userId);

    List<UserAction> getUserActionsByEventId(long eventId);
}
