package fr.hb.jordan_gadet.examen_spring_jordan_gadet.controller_api;


import fr.hb.jordan_gadet.examen_spring_jordan_gadet.custom_response.JwtResponse;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.dto.UserLoginDTO;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.dto.UserRegisterDTO;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.entity.User;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.security.JwtAuthenticatorService;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SecurityRestController {

    private final UserService userService;

    private final JwtAuthenticatorService jwtAuthenticatorService;

    @PostMapping("/api/register")
    public User register(@Valid @RequestBody UserRegisterDTO user) {
        return userService.create(user);
    }

    @PostMapping("/api/login")
    public ResponseEntity<JwtResponse> login(@RequestBody UserLoginDTO user) {
        return jwtAuthenticatorService.authenticate(user);
    }

}