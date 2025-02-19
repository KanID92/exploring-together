package core.event.controller.priv;

import core.api.dto.event.EventFullDto;
import core.api.dto.event.EventShortDto;
import core.api.dto.event.NewEventDto;
import core.api.dto.event.UpdateEventUserRequest;
import core.event.controller.params.EventGetByIdParams;
import core.event.controller.params.EventUpdateParams;
import core.event.controller.params.search.EventSearchParams;
import core.event.controller.params.search.PrivateSearchParams;
import core.event.service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/events")
@RequiredArgsConstructor
public class PrivateEventController {

    private final EventService eventService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventFullDto create(@PathVariable long userId, @Valid @RequestBody NewEventDto newEventDto) {
        return eventService.create(userId, newEventDto);
    }

    @GetMapping
    public List<EventShortDto> getAll(
            @PathVariable Long userId,
            @RequestParam(required = false, defaultValue = "0") Integer from,
            @RequestParam(required = false, defaultValue = "10") Integer size) {
        EventSearchParams searchParams = new EventSearchParams();
        searchParams.setPrivateSearchParams(new PrivateSearchParams(userId));
        searchParams.setFrom(from);
        searchParams.setSize(size);

        return eventService.getAllByInitiator(searchParams);
    }

    @GetMapping("/{eventId}")
    public EventFullDto getById(@PathVariable long userId, @PathVariable long eventId) {
        return eventService.getById(new EventGetByIdParams(userId, eventId));
    }

    @PatchMapping("/{eventId}")
    public EventFullDto update(@PathVariable long userId,
                               @PathVariable long eventId,
                               @Valid @RequestBody UpdateEventUserRequest updateEventDto) {
        return eventService.update(
                eventId, new EventUpdateParams(userId, updateEventDto, null));
    }

}
