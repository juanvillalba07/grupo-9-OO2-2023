package com.unla.smartcity.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class EventoModel {
    private Integer id;
    private String descripcion;
    private LocalDateTime fechaHora;
    private DispositivoModel dispositivo;

    public EventoModel(String descripcion, LocalDateTime fechaHora, DispositivoModel dispositivo) {
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
        this.dispositivo = dispositivo;
    }
}
