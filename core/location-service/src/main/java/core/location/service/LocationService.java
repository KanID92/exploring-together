package core.location.service;

import core.api.dto.location.LocationDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface LocationService {

    List<LocationDto> getTop(long userId, Integer count);

    Map<Long, LocationDto> getAllById(List<Long> locationIds);

    LocationDto create(@RequestBody LocationDto location);

    LocationDto getById(@PathVariable long locationId);



}
