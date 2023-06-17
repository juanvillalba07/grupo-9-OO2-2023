package com.unla.smartcity.services.implementation;

import com.unla.smartcity.entities.EventoEntity;
import com.unla.smartcity.entities.SensorEstacionamientoEntity;
import com.unla.smartcity.models.EventoModel;
import com.unla.smartcity.models.SensorEstacionamientoModel;
import com.unla.smartcity.repositories.IEventoRepository;
import com.unla.smartcity.repositories.ISensorEstacionamientoRepository;
import com.unla.smartcity.services.IEventoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service("eventoService")
public class EventoService implements IEventoService {

    @Autowired
    @Qualifier("eventoRepository")
    private IEventoRepository eventoRepository;
    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public EventoModel agregarEvento(EventoEntity eventoEntity) {
        EventoEntity evento = eventoRepository.save(eventoEntity);
        return modelMapper.map(evento, EventoModel.class);
    }

    @Override
    public List<EventoModel> getAll() {
        List<EventoModel> eventoModels = new ArrayList<>();
        eventoRepository.findAll().stream().forEach(evento ->{
            eventoModels.add(modelMapper.map(evento, EventoModel.class));
        });
        return eventoModels;
    }

    @Override
    public List<EventoModel> getEventosByFecha(LocalDateTime desde, LocalDateTime hasta){
        List<EventoModel> eventoModels = new ArrayList<>();
        eventoRepository.getEventosByFecha(desde, hasta).stream().forEach(evnto ->{
            eventoModels.add(modelMapper.map(evnto, EventoModel.class));
        });
        return eventoModels;
    }

    @Override
    public EventoModel getSensorById(int id) {
        EventoEntity evento = eventoRepository.findById(id);
        return modelMapper.map(evento, EventoModel.class);
    }
}
