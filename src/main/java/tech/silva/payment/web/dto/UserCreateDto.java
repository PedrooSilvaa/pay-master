package tech.silva.payment.web.dto;

import tech.silva.payment.entity.User;

public record UserCreateDto (String name,
                             String cpf){

    public User toUser(){
        User user = new User();
        user.setName(name);
        user.setCpf(cpf);
        return user;
    }

}
