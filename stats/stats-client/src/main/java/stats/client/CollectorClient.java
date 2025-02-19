package stats.client;

import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import id.kanygin.grpc.stats.actions.ActionTypeProto;
import id.kanygin.grpc.stats.actions.UserActionControllerGrpc;
import id.kanygin.grpc.stats.actions.UserActionProto;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Slf4j
@Component
public class CollectorClient {

    @GrpcClient("collector")
    private UserActionControllerGrpc.UserActionControllerBlockingStub collectorStub;

    public void sendUserAction(long userId, long eventId, ActionTypeProto userAction) {
        try {
            log.info("Sending userAction. UserId {}, eventId {}, userAction {}", userId, eventId, userAction);
            UserActionProto actionProto = UserActionProto.newBuilder()
                    .setUserId(userId)
                    .setEventId(eventId)
                    .setActionType(userAction)
                    .setTimestamp(Timestamp.newBuilder()
                            .setSeconds(Instant.now().getEpochSecond())
                            .setNanos(Instant.now().getNano())
                            .build())
                    .build();
            Empty response = collectorStub.collectUserAction(actionProto);
            log.info("UserAction sent: {}", actionProto);
        } catch (Exception e) {
            log.error("Error sending userActionProto: {}, {}, {}", userId, eventId, userAction, e);
        }
    }

}
