package sideProject.costControl.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sideProject.costControl.user.mapper.UserMapper;
import sideProject.costControl.user.service.UserService;

@RestController
@Slf4j
@Validated
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private UserService userService;
    private UserMapper userMapper;

    @PostMapping
    public ResponseEntity postUser() {
        return null;
    }

    @PatchMapping("/{user-id}")
    public ResponseEntity patchUser() {
        return null;
    }

    @GetMapping("/{user-id}")
    public ResponseEntity getUser() {
        return null;
    }

    @GetMapping
    public ResponseEntity getUsers() {
        return null;
    }

    @DeleteMapping("/{user-id}")
    public ResponseEntity deleteUser() {
        return null;
    }
}
