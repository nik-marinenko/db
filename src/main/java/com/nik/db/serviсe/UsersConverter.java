package com.nik.db.serviсe;

import com.nik.db.dto.UsersDTO;
import com.nik.db.entity.Users;
import org.springframework.stereotype.Component;


@Component
public class UsersConverter {
    public UsersDTO fromUserToUserDto(Users users){
        return UsersDTO.builder()
                .id(users.getId())
                .email(users.getEmail())
                .login(users.getLogin())
                .name(users.getName())
                .build();
    }

    public Users fromUserDtoToUser(UsersDTO usersDTO){
        Users users = new Users();
        users.setId(users.getId());
        users.setEmail(users.getEmail());
        users.setLogin(users.getLogin());
        users.setName(users.getName());
        return users;
    }
}
