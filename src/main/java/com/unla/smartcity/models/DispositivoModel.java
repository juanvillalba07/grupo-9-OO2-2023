package com.unla.smartcity.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class DispositivoModel {
    protected Integer id;
    protected String nombre;
    protected boolean activo;
}
