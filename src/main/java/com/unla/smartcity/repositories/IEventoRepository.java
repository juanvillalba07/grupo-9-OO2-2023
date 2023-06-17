package com.unla.smartcity.repositories;

import com.unla.smartcity.entities.EventoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Repository("eventoRepository")
public interface IEventoRepository extends JpaRepository<EventoEntity, Serializable> {
    public abstract EventoEntity findById(int id);
    @Query("SELECT e FROM EventoEntity e where e.fechaHora>=:desde and e.fechaHora<=:hasta")
    public abstract List<EventoEntity> getEventosByFecha(LocalDateTime desde,LocalDateTime hasta);
}
