//Передача данных между слоями
package com.nik.db.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class DTO {
    private Integer id;
    private String name;
    private String login;
    private String email;
}
