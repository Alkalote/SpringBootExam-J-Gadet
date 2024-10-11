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
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private Integer maximumTime;

    @Column(nullable = false)
    private Boolean hasMove;

    @Column(nullable = false)
    private Boolean hasPan;

    @Column(nullable = false)
    private Boolean hasZoom;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private Integer nbRounds;

    @OneToMany(mappedBy = "game")
    private List<Round> rounds = new ArrayList<>();

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;


    @ManyToOne
    @JoinColumn(nullable = false)
    private Map map;



    public Integer getTotalPoints(){
        Integer points = 0;

        for(int i =0;i<rounds.size();i++){
            points+=rounds.get(i).getPoints();
        }
        return points;

    }


}