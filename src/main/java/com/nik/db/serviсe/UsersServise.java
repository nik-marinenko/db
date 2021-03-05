package com.nik.db.servise;

import com.nik.db.dto.DTO;
import java.util.List;

public interface UsersServise {
    DTO saveUser(DTO usersDTO);

    void deleteUser(Integer userId);

    DTO findByLogin(String login);

    List<DTO> findAll();
}
