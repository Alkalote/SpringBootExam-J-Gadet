package fr.hb.jordan_gadet.examen_spring_jordan_gadet.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.jsonview.JsonViews;
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
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonView(JsonViews.GameList.class)
    private String id;

    @Column(nullable = false)
    @JsonView(JsonViews.GameShow.class)
    private Integer maximumTime;

    @Column(nullable = false)
    @JsonView(JsonViews.GameShow.class)
    private Boolean hasMove;

    @Column(nullable = false)
    @JsonView(JsonViews.GameShow.class)
    private Boolean hasPan;

    @Column(nullable = false)
    @JsonView(JsonViews.GameShow.class)
    private Boolean hasZoom;

    @Column(nullable = false)
    @JsonView({JsonViews.GameList.class,JsonViews.GameShow.class})
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @JsonView({JsonViews.GameList.class,JsonViews.GameShow.class})
    private Integer nbRounds;

    @OneToMany(mappedBy = "game")
    @JsonView(JsonViews.GameShow.class)
    private List<Round> rounds = new ArrayList<>();

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonView(JsonViews.GameList.class)
    private User user;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Map map;

    @JsonView({JsonViews.GameList.class,JsonViews.GameShow.class})
    public Integer getTotalPoints(){
        Integer points = 0;

        for(int i =0;i<rounds.size();i++){
            points+=rounds.get(i).getPoints();
        }
        return points;

    }


}