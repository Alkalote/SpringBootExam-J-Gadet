package fr.hb.jordan_gadet.examen_spring_jordan_gadet.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.jsonview.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Coordinate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @JsonView(JsonViews.CoordianteShow.class)
    private String longitude;

    @Column(nullable = false)
    @JsonView(JsonViews.CoordianteShow.class)
    private String latitude;

}