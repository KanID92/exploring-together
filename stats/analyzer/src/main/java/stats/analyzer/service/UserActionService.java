package stats.analyzer.service;


import id.kanygin.stats.avro.UserActionAvro;
import stats.analyzer.entity.UserAction;

public interface UserActionService {

    UserAction save(UserActionAvro userActionAvro);

}
