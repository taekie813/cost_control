package sideProject.costControl.user.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sideProject.costControl.user.dto.UserDto;
import sideProject.costControl.user.entity.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-16T08:46:18+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.18 (Azul Systems, Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User userPostDtoToUser(UserDto.Post requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        User user = new User();

        if ( requestBody.getUserId() != null ) {
            user.setUserId( requestBody.getUserId() );
        }
        user.setEmail( requestBody.getEmail() );
        user.setNickName( requestBody.getNickName() );
        user.setPassword( requestBody.getPassword() );

        return user;
    }

    @Override
    public User userPatchDtoToUser(UserDto.Patch requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        User user = new User();

        if ( requestBody.getUserId() != null ) {
            user.setUserId( requestBody.getUserId() );
        }
        user.setEmail( requestBody.getEmail() );
        user.setNickName( requestBody.getNickName() );

        return user;
    }

    @Override
    public UserDto.Response userToUserResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto.Response response = new UserDto.Response();

        response.setNickName( user.getNickName() );
        response.setEmail( user.getEmail() );
        response.setUserStatus( user.getUserStatus() );

        return response;
    }

    @Override
    public List<UserDto.Response> usersToUserResponseDtos(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDto.Response> list = new ArrayList<UserDto.Response>( users.size() );
        for ( User user : users ) {
            list.add( userToUserResponseDto( user ) );
        }

        return list;
    }
}
