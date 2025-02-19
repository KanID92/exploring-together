package core.api.dto.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import core.api.constant.Constants;
import core.api.dto.category.CategoryDto;
import core.api.dto.location.LocationDto;
import core.api.dto.user.UserShortDto;
import core.api.enums.EventState;

import java.time.LocalDateTime;

public record EventFullDto(

        String annotation,

        CategoryDto category,

        long confirmedRequests,

        @JsonFormat(pattern = Constants.JSON_TIME_FORMAT, shape = JsonFormat.Shape.STRING)
        LocalDateTime createdOn,

        String description,

        @JsonFormat(pattern = Constants.JSON_TIME_FORMAT, shape = JsonFormat.Shape.STRING)
        LocalDateTime eventDate,

        Long id,

        UserShortDto initiator,

        LocationDto location,

        boolean paid,

        Integer participantLimit,

        @JsonFormat(pattern = Constants.JSON_TIME_FORMAT, shape = JsonFormat.Shape.STRING)
        LocalDateTime publishedOn,

        boolean requestModeration,

        EventState state,

        String title,

        double rating,

        long likesCount


) {

}
