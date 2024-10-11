package fr.hb.jordan_gadet.examen_spring_jordan_gadet.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRegisterDTO {

    @NotBlank
    private String email;

    @NotBlank
    private String username;

    private LocalDateTime birthedAt;

    private String avatar;;

    @NotBlank
    private String password;
    @NotBlank
    private String password2;



}