package com.unla.smartcity.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SensorHumedadModel extends DispositivoModel {
    private double humedadActual;
    private boolean estado;
}
