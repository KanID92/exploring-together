package stats.analyzer.service.mapper;

import id.kanygin.stats.avro.ActionTypeAvro;
import id.kanygin.stats.avro.UserActionAvro;
import org.springframework.stereotype.Component;
import stats.analyzer.entity.ActionType;
import stats.analyzer.entity.UserAction;

@Component
public class GeneralUserActionMapper implements UserActionMapper {

    @Override
    public UserAction toUserAction(UserActionAvro actionAvro) {
        return UserAction.builder()
                .userId(actionAvro.getUserId())
                .eventId(actionAvro.getEventId())
                .actionType(toActionType(actionAvro.getActionType()))
                .timestamp(actionAvro.getTimestamp())
                .build();
    }

    private ActionType toActionType(ActionTypeAvro actionTypeAvro) {
        switch (actionTypeAvro) {
            case VIEW -> {
                return ActionType.VIEW;
            }
            case REGISTER -> {
                return ActionType.REGISTER;
            }
            case LIKE -> {
                return ActionType.LIKE;
            }
            default -> throw new RuntimeException("actionTypeAvro: " + actionTypeAvro + " is not supported");
        }
    }
}
