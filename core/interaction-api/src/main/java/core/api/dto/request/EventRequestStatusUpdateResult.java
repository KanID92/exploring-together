package core.api.dto.request;

import java.util.List;

public record EventRequestStatusUpdateResult(

        List<ParticipationRequestDto> confirmedRequests,

        List<ParticipationRequestDto> rejectedRequests

) {
}
