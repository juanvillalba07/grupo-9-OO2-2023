package com.unla.smartcity.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SensorHumedadModel extends DispositivoModel {
    @NotNull @Min(1) @Max(100)
    private int humedadActual;
    private boolean estado;
}
