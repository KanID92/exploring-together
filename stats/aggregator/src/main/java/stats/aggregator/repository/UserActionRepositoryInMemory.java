package stats.aggregator.repository;

import id.kanygin.stats.avro.ActionTypeAvro;
import id.kanygin.stats.avro.UserActionAvro;
import org.springframework.stereotype.Repository;
import stats.aggregator.configuration.kafka.UserActionWeight;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserActionRepositoryInMemory implements UserActionRepository {

    Map<Long, Map<Long, Double>> usersActions = new HashMap<>();


    @Override
    public Map<Long, Double> getActionsByEvent(Long eventId) {
        return usersActions
                .computeIfAbsent(eventId, k -> new HashMap<>());
    }

    @Override
    public void save(UserActionAvro userAction) {
        getActionsByEvent(userAction.getEventId())
                .put(userAction.getUserId(), getWeightFromAvro(userAction.getActionType()));
        Map<Long, Double> actionAvroMap = getActionsByEvent(userAction.getEventId());
        actionAvroMap.put(userAction.getUserId(), getWeightFromAvro(userAction.getActionType()));
        usersActions.put(
                userAction.getEventId(), actionAvroMap);
    }

    public double getWeightFromAvro(ActionTypeAvro actionType) {
        switch (actionType) {
            case VIEW -> {
                return UserActionWeight.view;
            }
            case REGISTER -> {
                return UserActionWeight.register;
            }
            case LIKE -> {
                return UserActionWeight.like;
            }
            default -> {
                return 0f;
            }
        }
    }


}
