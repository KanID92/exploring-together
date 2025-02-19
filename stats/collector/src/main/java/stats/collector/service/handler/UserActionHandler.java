package stats.collector.service.handler;


import id.kanygin.grpc.stats.actions.UserActionProto;

public interface UserActionHandler {

    void handle(UserActionProto userActionProto);

}
