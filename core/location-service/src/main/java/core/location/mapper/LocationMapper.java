package core.location.mapper;

import core.api.dto.location.LocationDto;
import core.location.entity.Location;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface LocationMapper {

    LocationDto locationToLocationDto(Location location);

    Location locationDtoToLocation(LocationDto locationDto);
}
