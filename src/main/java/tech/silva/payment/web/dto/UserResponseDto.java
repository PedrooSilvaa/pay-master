package tech.silva.payment.web.dto;

import tech.silva.payment.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public record UserResponseDto (Long id,
                               String name,
                               String cpf,
                               float value){

    public UserResponseDto(Long id, String name, String cpf, float value) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.value = value;
    }

    public static UserResponseDto toUserResponse(User user){
        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getCpf(),
                user.getValue()
        );
    }

    public static List<UserResponseDto> toListUserResponse(List<User> users){
        return users.stream()
                .map(UserResponseDto::toUserResponse).collect(Collectors.toList());
    }
}
