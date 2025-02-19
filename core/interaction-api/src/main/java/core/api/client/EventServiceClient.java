package core.api.client;

import core.api.dto.event.EventFullDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "event-service")
public interface EventServiceClient {

    @GetMapping("/internal/events/{eventId}")
    EventFullDto getById(@PathVariable long eventId);

}
