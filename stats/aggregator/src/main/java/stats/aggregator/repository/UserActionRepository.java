package stats.aggregator.repository;

import id.kanygin.stats.avro.ActionTypeAvro;
import id.kanygin.stats.avro.UserActionAvro;

import java.util.Map;

public interface UserActionRepository {


     Map<Long, Double> getActionsByEvent(Long eventId);

     void save(UserActionAvro userAction);

     double getWeightFromAvro(ActionTypeAvro actionType);

}
