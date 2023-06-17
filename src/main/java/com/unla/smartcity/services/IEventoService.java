package com.unla.smartcity.services;

import com.unla.smartcity.entities.EventoEntity;
import com.unla.smartcity.models.EventoModel;

import java.time.LocalDateTime;
import java.util.List;

public interface IEventoService {

    public EventoModel agregarEvento(EventoEntity eventoEntity);
    public List<EventoModel> getAll();
    public List<EventoModel> getEventosByFecha(LocalDateTime desde, LocalDateTime hasta);
    public EventoModel getSensorById(int id);
}
