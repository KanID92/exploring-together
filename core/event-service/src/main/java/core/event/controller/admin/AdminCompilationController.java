package core.event.controller.admin;

import core.api.dto.compilation.CompilationDto;
import core.api.dto.compilation.NewCompilationDto;
import core.api.dto.compilation.UpdateCompilationRequestDto;
import core.event.service.CompilationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/admin/compilations")
@RequiredArgsConstructor
public class AdminCompilationController {
    private final CompilationService compilationService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompilationDto createCompilation(
            @Valid @RequestBody NewCompilationDto dto) {
        return compilationService.createCompilation(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompilation(@PathVariable long id) {
        compilationService.delete(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CompilationDto updateCompilation(@PathVariable long id, @Valid @RequestBody UpdateCompilationRequestDto compilationDto) {
        return compilationService.updateCompilation(id, compilationDto);
    }
}