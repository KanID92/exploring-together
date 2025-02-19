package stats.analyzer.service.mapper;


import id.kanygin.stats.avro.UserActionAvro;
import stats.analyzer.entity.UserAction;

public interface UserActionMapper {

    UserAction toUserAction(final UserActionAvro actionAvro);
}
