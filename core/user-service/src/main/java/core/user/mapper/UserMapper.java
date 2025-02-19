package core.user.mapper;

import core.api.dto.user.UserCreateDto;
import core.api.dto.user.UserDto;
import core.api.dto.user.UserShortDto;
import core.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User userCreateDtoToUser(UserCreateDto userCreateDto);

    UserDto userToUserDto(User user);

    UserShortDto userToUserShotDto(User user);

}
