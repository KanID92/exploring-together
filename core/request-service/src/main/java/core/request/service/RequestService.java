package core.request.service;


import core.api.dto.request.EventRequestStatusUpdateResult;
import core.api.dto.request.ParticipationRequestDto;
import core.api.enums.RequestStatus;
import core.request.controller.PrivateUpdateRequestParams;

import java.util.List;
import java.util.Map;

public interface RequestService {

    ParticipationRequestDto create(long userId, long eventId);

    List<ParticipationRequestDto> getAllOwnRequests(long userId);

    ParticipationRequestDto cancel(long userId, long requestId);

    List<ParticipationRequestDto> getAllForOwnEvent(long userId, long eventId);

    EventRequestStatusUpdateResult updateStatus(PrivateUpdateRequestParams params);

    long countByStatusAndEventId(RequestStatus status, long eventId);

    Map<Long, Long> countByStatusAndEventsIds(RequestStatus status, List<Long> eventsIds);

    boolean existsByEventIdAndRequesterIdAndStatus(long eventId, long requesterId, RequestStatus status);

}
