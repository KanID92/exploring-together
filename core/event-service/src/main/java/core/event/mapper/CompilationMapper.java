package core.event.mapper;

import core.api.dto.compilation.CompilationDto;
import core.api.dto.compilation.NewCompilationDto;
import core.api.dto.event.EventShortDto;
import core.event.entity.Compilation;
import core.event.entity.Event;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CompilationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "events", source = "events")
    Compilation toCompilation(final NewCompilationDto compilationDto, final List<Event> events);

    @Mapping(target = "events", source = "list")
    CompilationDto toCompilationDto(final Compilation compilation, List<EventShortDto> list);
}