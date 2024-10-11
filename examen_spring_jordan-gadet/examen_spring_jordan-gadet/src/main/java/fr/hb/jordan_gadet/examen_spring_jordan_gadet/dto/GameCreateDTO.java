package fr.hb.jordan_gadet.examen_spring_jordan_gadet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GameCreateDTO {

    @NotNull
    private Boolean hasPan;

    @NotNull
    private Boolean hasZoom;

    @NotNull
    private Boolean hasMove;

    @NotNull
    private Integer maximumTime;

    @NotNull
    private Integer round;

    @NotNull
    private Long mapId;

    @NotBlank
    private String userId;


}