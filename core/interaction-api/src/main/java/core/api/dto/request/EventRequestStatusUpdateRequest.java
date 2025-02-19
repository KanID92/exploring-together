package core.api.dto.request;

import core.api.enums.RequestStatus;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record EventRequestStatusUpdateRequest(

        List<Long> requestIds,

        @NotNull
        RequestStatus status

) {
}
