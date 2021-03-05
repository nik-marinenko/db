package com.nik.db.serviсe;

import com.nik.db.dto.UsersDTO;
import java.util.List;

public interface UsersServise {
    UsersDTO saveUser(UsersDTO usersDTO);

    void deleteUser(Integer userId);

    UsersDTO findByLogin(String login);

    List<UsersDTO> findAll();
}
