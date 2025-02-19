package core.user.controller;

import core.api.dto.user.UserDto;
import core.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/internal/users")
@RequiredArgsConstructor
public class InternalUserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public UserDto getById(@PathVariable long userId) {
        return userService.getById(userId);
    }

    @GetMapping("/{userId}/check")
    public void checkExistence(@PathVariable("userId") long userId) {
        userService.checkExistence(userId);
    }

    @GetMapping("/all")
    public Map<Long, UserDto> getAll(@RequestParam List<Long> userIds) {
        return userService.getByIds(userIds);
    }

}
