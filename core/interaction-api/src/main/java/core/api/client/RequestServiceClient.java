package core.api.client;

import core.api.enums.RequestStatus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "request-service")
public interface RequestServiceClient {

    @GetMapping("/internal/requests/count/{eventId}")
    long countByStatusAndEventId(@RequestParam RequestStatus status, @PathVariable long eventId);

    @GetMapping("/internal/requests/count")
    Map<Long, Long> countByStatusAndEventsIds(
            @RequestParam RequestStatus status, @RequestParam List<Long> eventsIds);

    @GetMapping("/internal/requests/{eventId}/{userId}/status")
    boolean isUserHasConfirmedRequest(@PathVariable long eventId, @PathVariable long userId);

}
