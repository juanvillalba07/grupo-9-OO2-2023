package com.unla.smartcity.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class SensorAlumbradoEntity extends DispositivoEntity{
        
	@Column
    private String lugar;

	@Column
    private int luzAmbiente;
    
	@Column
	private int intensidad;

}
