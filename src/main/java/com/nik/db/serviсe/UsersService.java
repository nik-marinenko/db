package com.nik.db.serviсe;

import com.nik.db.dto.UsersDTO;
import com.nik.db.exception.ValidationException;

import java.util.List;


public interface UsersService {

    UsersDTO saveUser(UsersDTO usersDTO) throws ValidationException;

    void deleteUser(Integer userId);

    UsersDTO findByLogin(String login);

    List<UsersDTO> findAll();
}
