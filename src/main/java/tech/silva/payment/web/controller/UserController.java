package tech.silva.payment.web.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.silva.payment.entity.User;
import tech.silva.payment.service.UserService;
import tech.silva.payment.web.dto.UserCreateDto;
import tech.silva.payment.web.dto.UserResponseDto;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> saveUser(@RequestBody UserCreateDto userCreateDto){
        User user = userService.createUser(userCreateDto.toUser());
        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponseDto.toUserResponse(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable Long id){
        User user = userService.findById(id);
        if (user == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(UserResponseDto.toUserResponse(user));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAll(){
        List<User> users = userService.listAll();
        return ResponseEntity.ok(UserResponseDto.toListUserResponse(users));
    }
}
