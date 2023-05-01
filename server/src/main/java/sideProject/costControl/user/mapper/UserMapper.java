package sideProject.costControl.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import sideProject.costControl.user.dto.UserDto;
import sideProject.costControl.user.entity.User;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User userPostDtoToUser(UserDto.Post requestBody);
    User userPatchDtoToUser(UserDto.Patch requestBody);
    UserDto.Response userToUserResponseDto(User user);
    List<UserDto.Response> usersToUserResponseDtos(List<User> users);
}
