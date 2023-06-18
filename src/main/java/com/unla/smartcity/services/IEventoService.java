package com.unla.smartcity.services;

import com.unla.smartcity.entities.EventoEntity;
import com.unla.smartcity.entities.SensorHumedadEntity;
import com.unla.smartcity.models.EventoModel;
import java.util.List;

public interface IEventoService {

    public EventoModel agregarEvento(EventoEntity eventoEntity);
    public List<EventoModel> getAll();
    public EventoModel getSensorById(int id);
}
