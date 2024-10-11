package fr.hb.jordan_gadet.examen_spring_jordan_gadet.entity;

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
    private Long id;

    private Integer points = null;

    private Integer time = null;

    private Long distance = null;

    @Column(nullable = false)
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