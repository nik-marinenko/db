package com.nik.db.serviсe;

import com.nik.db.dto.UsersDTO;
import com.nik.db.entity.Users;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Log
@Component
public class UsersConverter {
    public UsersDTO fromUserToUserDto(Users users){
        log.info("converter to UsersDTO" + UsersDTO.builder());
        return UsersDTO.builder()
                .id(users.getId())
                .name(users.getName())
                .login(users.getLogin())
                .email(users.getEmail())
                .build();
    }

    public Users fromUserDtoToUser(UsersDTO usersDTO){
        Users users = new Users();
        users.setId(usersDTO.getId());
        users.setEmail(usersDTO.getEmail());
        users.setLogin(usersDTO.getLogin());
        users.setName(usersDTO.getName());
        log.info("converter to user" + users);
        return users;
    }
}
