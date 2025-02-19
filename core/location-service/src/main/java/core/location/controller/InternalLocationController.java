package core.location.controller;

import core.api.dto.location.LocationDto;
import core.location.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/internal/locations")
public class InternalLocationController {
    private final LocationService locationService;

    @GetMapping("/{locationId}")
    public LocationDto getById(@PathVariable long locationId) {
        return locationService.getById(locationId);
    }

    @GetMapping("/all")
    public Map<Long, LocationDto> getAllById(@RequestParam List<Long> locationIds) {
        return locationService.getAllById(locationIds);
    }

}
