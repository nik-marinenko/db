package com.nik.db.serviсe;

import com.nik.db.dto.UsersDTO;
import com.nik.db.entity.Users;
import com.nik.db.exception.ValidationException;
import com.nik.db.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultUsersService implements UsersService{

    private final UsersRepository usersRepository;
    private final UsersConverter usersConverter;


    private void validateUserDto(UsersDTO usersDto) throws ValidationException {
        if(isNull(usersDto)){
            throw new ValidationException("Object user is null");
        }
        if(isNull(usersDto.getLogin())||usersDto.getLogin().isEmpty()){
            throw new ValidationException("Login is empty");
        }

    }


    public Users fromUserDtoToUser(UsersDTO usersDTO){
        Users users = new Users();
        users.setId(usersDTO.getId());
        users.setEmail(usersDTO.getEmail());
        users.setName(usersDTO.getName());
        users.setLogin(usersDTO.getLogin());
        return users;
    }

    @Override
    public  UsersDTO saveUser(UsersDTO usersDTO) throws ValidationException{
        validateUserDto(usersDTO); //валидация входящих данных
        Users savedUser = usersRepository.save(usersConverter.fromUserDtoToUser(usersDTO)); //конвертация в юзера и сохранение в бд
        return usersConverter.fromUserToUserDto(savedUser); //конвертация сохраненного юзера в дто
    }

    @Override
    public void deleteUser(Integer userId){
        usersRepository.deleteById(userId); //удаление юзера по id
    }

    @Override
    public UsersDTO findByLogin(String login){ //поиск по логину
        Users users = usersRepository.findByLogin(login);
        if(users!= null){
            return usersConverter.fromUserToUserDto(users);
        }
        return null;
    }

    @Override
    public List<UsersDTO> findAll(){
        return usersRepository.findAll()
                .stream()
                .map(usersConverter::fromUserToUserDto)
                .collect(Collectors.toList());
    }

}
