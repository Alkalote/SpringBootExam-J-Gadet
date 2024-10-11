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
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.MapList.class)
    private Long id;

    @Column(nullable = false)
    @JsonView(JsonViews.MapList.class)
    private String name;

    @Column(nullable = false)
    @JsonView(JsonViews.MapShow.class)
    private LocalDateTime createdAt;

}