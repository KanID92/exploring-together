package stats.collector.service.handler;

import id.kanygin.grpc.stats.actions.ActionTypeProto;
import id.kanygin.grpc.stats.actions.UserActionProto;
import id.kanygin.stats.avro.ActionTypeAvro;
import id.kanygin.stats.avro.UserActionAvro;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.stereotype.Component;
import stats.collector.configuration.KafkaUserActionProducer;

import java.time.Instant;

@Slf4j
@Component
public class UserActionHandlerImpl extends BaseUserActionHandler {

    public UserActionHandlerImpl(KafkaUserActionProducer kafkaUserActionProducer) {
        super(kafkaUserActionProducer);
    }

    @Override
    SpecificRecordBase toAvro(UserActionProto userAction) {
        log.info("Converting to Avro UserActionProto");
        return UserActionAvro.newBuilder()
                .setUserId(userAction.getUserId())
                .setEventId(userAction.getEventId())
                .setActionType(toActionTypeAvro(userAction.getActionType()))
                .setTimestamp(Instant.ofEpochSecond(userAction.getTimestamp().getSeconds(), userAction.getTimestamp().getNanos()))
                .build();
    }

    private ActionTypeAvro toActionTypeAvro(ActionTypeProto userTypeProto) {
        return switch (userTypeProto) {
            case ActionTypeProto.ACTION_VIEW -> ActionTypeAvro.VIEW;
            case ActionTypeProto.ACTION_LIKE -> ActionTypeAvro.LIKE;
            case ActionTypeProto.ACTION_REGISTER -> ActionTypeAvro.REGISTER;
            default -> null;
        };
    }


}