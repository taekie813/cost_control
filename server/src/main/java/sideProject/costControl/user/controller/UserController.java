package sideProject.costControl.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sideProject.costControl.dto.MultiResponseDto;
import sideProject.costControl.dto.SingleResponseDto;
import sideProject.costControl.user.dto.UserDto;
import sideProject.costControl.user.entity.User;
import sideProject.costControl.user.mapper.UserMapper;
import sideProject.costControl.user.service.UserService;
import sideProject.costControl.utils.UriCreator;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

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
    public ResponseEntity postUser(@Valid @RequestBody UserDto.Post requestBody) {
        User user = userMapper.userPostDtoToUser(requestBody);
        User createUser = userService.createUser(user);

        URI location = UriCreator.createUri(USER_DEFAULT_URL, createUser.getUserId());

        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{user-id}")
    public ResponseEntity patchUser(@PathVariable("user-id") @Positive long userId,
                                    @Valid @RequestBody UserDto.Patch requestBody) {
        requestBody.addUserId(userId);
        User user = userMapper.userPatchDtoToUser(requestBody);
        User createdUser = userService.updateUser(user);

        return new ResponseEntity<>(
                new SingleResponseDto<>(userMapper.userToUserResponseDto(createdUser)), HttpStatus.OK);
    }

    @GetMapping("/{user-id}")
    public ResponseEntity getUser(@PathVariable("user-id") @Positive long userId) {
        User user = userService.findUser(userId);
        return new ResponseEntity<>(
                new SingleResponseDto<>(userMapper.userToUserResponseDto(user)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getUsers(@PathVariable("user-id") @Positive long userId,
                                   @RequestParam(value = "page") int page,
                                   @RequestParam(value = "size") int size) {
        Page<User> userPage = userService.findUsers(page, size);
        List<User> users = userPage.getContent();
        return new ResponseEntity<>(
                new MultiResponseDto<>(userMapper.usersToUserResponseDtos(users), userPage), HttpStatus.OK);
    }

    @DeleteMapping("/{user-id}")
    public ResponseEntity deleteUser(@PathVariable("user-id") @Positive long userId) {
        userService.deleteUser(userId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
