package com.unla.smartcity.models;

import com.unla.smartcity.enums.Estado;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SensorEstacionamientoModel extends DispositivoModel {
    private Estado estado;
    private String lugar;
}
