package com.unla.smartcity.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.smartcity.entities.SensorAlumbradoEntity;
import com.unla.smartcity.models.SensorAlumbradoModel;

@Repository("sensorAlumbradoRepository")
public interface ISensorAlumbradoRepository extends JpaRepository<SensorAlumbradoEntity, Serializable> {

	public abstract SensorAlumbradoEntity findById(int id);

	public abstract SensorAlumbradoModel findByLugar(String lugar);
}
