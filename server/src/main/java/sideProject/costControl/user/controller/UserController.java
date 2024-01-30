package sideProject.costControl.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sideProject.costControl.dto.SingleResponseDto;
import sideProject.costControl.user.dto.UserDto;
import sideProject.costControl.user.entity.User;
import sideProject.costControl.user.mapper.UserMapper;
import sideProject.costControl.user.service.UserService;
import sideProject.costControl.utils.UriCreator;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;

@RestController
@Slf4j
@Validated
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final static String USER_DEFAULT_URL = "/users";
    private UserService userService;
    private UserMapper userMapper;

    @PostMapping
    public ResponseEntity postUser(@Positive long userId, @Valid @RequestBody UserDto.Post requestBody) {
        User user = userMapper.userPostDtoToUser(requestBody);
        User createUser = userService.createUser(user);

        URI location = UriCreator.createUri(USER_DEFAULT_URL, createUser.getUserId());

        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/user/{user-id}")
    public ResponseEntity patchUser() {
        return null;
    }

    @GetMapping("/user/{user-id}")
    public ResponseEntity getUser() {
        return null;
    }

    @GetMapping
    public ResponseEntity getUsers() {
        return null;
    }

    @DeleteMapping("/user/{user-id}")
    public ResponseEntity deleteUser() {
        return null;
    }
}
