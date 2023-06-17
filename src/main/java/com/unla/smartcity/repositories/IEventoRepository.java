package com.unla.smartcity.repositories;

import com.unla.smartcity.entities.EventoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("eventoRepository")
public interface IEventoRepository extends JpaRepository<EventoEntity, Serializable> {
    public abstract EventoEntity findById(int id);
}
