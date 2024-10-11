package fr.hb.jordan_gadet.examen_spring_jordan_gadet.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.jsonview.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.RoundShow.class)
    private Long id;

    @JsonView({JsonViews.GameShow.class,JsonViews.RoundShow.class})
    private Integer points = null;

    @JsonView({JsonViews.GameShow.class,JsonViews.RoundShow.class})
    private Integer time = null;

    @JsonView({JsonViews.GameShow.class,JsonViews.RoundShow.class})
    private Long distance = null;

    @Column(nullable = false)
    @JsonView(JsonViews.RoundShow.class)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Game game;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Coordinate origin;

    @ManyToOne
    private Coordinate selected;


}