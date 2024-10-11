package fr.hb.jordan_gadet.examen_spring_jordan_gadet.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserLoginDTO {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

}