package core.event.controller.params;

import core.api.dto.event.UpdateEventAdminRequest;
import core.api.dto.event.UpdateEventUserRequest;

public record EventUpdateParams(
        Long userId,
        UpdateEventUserRequest updateEventUserRequest,
        UpdateEventAdminRequest updateEventAdminRequest
) {
}
