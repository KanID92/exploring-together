package core.api.dto.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import core.api.constant.Constants;
import core.api.dto.event.annotation.FutureAfterTwoHours;
import core.api.dto.location.LocationDto;
import core.api.enums.StateAction;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record UpdateEventAdminRequest(

        @Size(min = 20, max = 2000)
        String annotation,

        Long category,

        @Size(min = 20, max = 7000)
        String description,

        @FutureAfterTwoHours @JsonFormat(pattern = Constants.JSON_TIME_FORMAT)
        LocalDateTime eventDate,

        LocationDto location,

        Boolean paid,

        @PositiveOrZero
        Integer participantLimit,

        Boolean requestModeration,

        StateAction stateAction,

        @Size(min = 3, max = 120)
        String title

) {
}
