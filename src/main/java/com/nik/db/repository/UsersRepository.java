package com.nik.db.repository;

import com.nik.db.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UsersRepository extends JpaRepository<Users, Integer> {

    Users findByLogin(String login);//поиск пользователя по логину
}