package fr.hb.jordan_gadet.examen_spring_jordan_gadet.custom_response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JwtResponse {

    private String token;

}
