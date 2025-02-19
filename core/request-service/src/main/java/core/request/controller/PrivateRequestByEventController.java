package core.request.controller;

import core.api.dto.request.EventRequestStatusUpdateRequest;
import core.api.dto.request.EventRequestStatusUpdateResult;
import core.api.dto.request.ParticipationRequestDto;
import core.request.service.RequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/events")
@RequiredArgsConstructor
public class PrivateRequestByEventController {

    private final RequestService requestService;

    @GetMapping("/{eventId}/requests")
    public List<ParticipationRequestDto> getAllRequestsForOwnEvent(
            @PathVariable long userId,
            @PathVariable long eventId) {

        return requestService.getAllForOwnEvent(userId, eventId);
    }

    @PatchMapping("/{eventId}/requests")
    public EventRequestStatusUpdateResult updateRequestStatus(
            @PathVariable long userId,
            @PathVariable long eventId,
            @RequestBody @Valid EventRequestStatusUpdateRequest updateRequestStatusDto) {

        return requestService.updateStatus(new PrivateUpdateRequestParams(userId, eventId, updateRequestStatusDto));
    }

}
