package core.api.dto.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import core.api.constant.Constants;
import core.api.dto.category.CategoryDto;
import core.api.dto.location.LocationDto;
import core.api.dto.user.UserShortDto;

import java.time.LocalDateTime;

public record EventShortDto(

        String annotation,

        CategoryDto category,

        Long confirmedRequests,

        @JsonFormat(pattern = Constants.JSON_TIME_FORMAT, shape = JsonFormat.Shape.STRING)
        LocalDateTime createOn,

        String description,

        @JsonFormat(pattern = Constants.JSON_TIME_FORMAT, shape = JsonFormat.Shape.STRING)
        LocalDateTime eventDate,

        Long id,

        UserShortDto initiator,

        LocationDto location,

        boolean paid,

        String title,

        Long views,

        Long likesCount

) {
}
