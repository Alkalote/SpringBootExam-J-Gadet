package fr.hb.jordan_gadet.examen_spring_jordan_gadet.controller_api;

import fr.hb.jordan_gadet.examen_spring_jordan_gadet.entity.User;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.jsonview.JsonViews;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserRestController {

    private UserService Service;

    @GetMapping("/me")
    @JsonView(JsonViews.UserShow.class)
    public User show(Principal principal) {
        return Service.findUser(principal);
    }



}