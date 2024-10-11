package fr.hb.jordan_gadet.examen_spring_jordan_gadet.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.jsonview.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonView({JsonViews.UserShow.class,JsonViews.GameList.class})
    private String id;

    @Column(nullable = false)
    @JsonView({JsonViews.UserShow.class,JsonViews.GameList.class})
    private String username;

    @Column(nullable = false)
    @JsonView(JsonViews.UserShow.class)
    private String email;

    @Column(nullable = false)
    private String password;

    @JsonView(JsonViews.UserShow.class)
    private String avatar = null;

    @JsonView(JsonViews.UserShow.class)
    private LocalDateTime birthedAt;

    @Column(nullable = false)
    @JsonView(JsonViews.UserShow.class)
    private LocalDateTime createdAt;

    @JsonView({JsonViews.UserShow.class,JsonViews.GameList.class})
    private Integer level =1;

    @Column(nullable = false)
    private String roles;


    @OneToMany(mappedBy = "user")
    private List<Game> games = new ArrayList<>();


    @JsonView(JsonViews.UserShow.class)
    public Boolean isAdmin(){
        return roles.contains("ADMIN");
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return email;
    }
}