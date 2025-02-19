package core.event.controller.admin;

import core.api.constant.Constants;
import core.api.dto.event.EventFullDto;
import core.api.dto.event.UpdateEventAdminRequest;
import core.api.enums.EventState;
import core.event.controller.params.EventUpdateParams;
import core.event.controller.params.search.AdminSearchParams;
import core.event.controller.params.search.EventSearchParams;
import core.event.service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin/events")
@RequiredArgsConstructor
public class AdminEventController {

    private final EventService eventService;

    @PatchMapping("{eventId}")
    public EventFullDto update(
            @PathVariable long eventId,
            @RequestBody @Valid UpdateEventAdminRequest updateEventAdminRequest) {
        return eventService.update(
                eventId, new EventUpdateParams(null, null, updateEventAdminRequest));
    }

    @GetMapping
    public List<EventFullDto> getAll(
            @RequestParam(required = false) List<Long> users,
            @RequestParam(required = false) List<EventState> states,
            @RequestParam(required = false) List<Long> categories,
            @RequestParam(required = false) @DateTimeFormat(pattern = Constants.JSON_TIME_FORMAT) LocalDateTime rangeStart,
            @RequestParam(required = false) @DateTimeFormat(pattern = Constants.JSON_TIME_FORMAT) LocalDateTime rangeEnd,
            @RequestParam(defaultValue = "0") Integer from,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        EventSearchParams eventSearchParams = new EventSearchParams();
        AdminSearchParams adminSearchParams = new AdminSearchParams();
        adminSearchParams.setUsers(users);
        adminSearchParams.setStates(states);
        adminSearchParams.setCategories(categories);
        adminSearchParams.setRangeStart(rangeStart);
        adminSearchParams.setRangeEnd(rangeEnd);
        eventSearchParams.setAdminSearchParams(adminSearchParams);
        eventSearchParams.setFrom(from);
        eventSearchParams.setSize(size);
        return eventService.getAllByAdmin(eventSearchParams);
    }

}
