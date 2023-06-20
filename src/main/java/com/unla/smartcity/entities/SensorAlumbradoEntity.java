package com.unla.smartcity.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class SensorAlumbradoEntity extends DispositivoEntity{
        
	@Column
    private String lugar;

	@Column 
	@Min(1) @Max(10)
    private int luzAmbiente;
    
	@Column
	@Min(0) @Max(100)
	private int intensidad;

    private boolean estado;
}
