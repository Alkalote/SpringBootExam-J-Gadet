package fr.hb.jordan_gadet.examen_spring_jordan_gadet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String avatar = null;

    private LocalDateTime birthedAt;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private Integer level =1;

    @Column(nullable = false)
    private String roles;


    @OneToMany(mappedBy = "user")
    private List<Game> games = new ArrayList<>();


    public Boolean isAdmin(){
        return roles.contains("ADMIN");
    }


}