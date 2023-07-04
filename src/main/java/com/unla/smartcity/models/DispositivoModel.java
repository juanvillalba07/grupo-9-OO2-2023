package com.unla.smartcity.models;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DispositivoModel {
    protected Integer id;
    @NotEmpty
    protected String nombre;
    protected boolean activo;
}
