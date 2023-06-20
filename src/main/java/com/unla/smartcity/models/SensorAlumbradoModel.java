package com.unla.smartcity.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Getter @Setter @NoArgsConstructor
public class SensorAlumbradoModel extends DispositivoModel {

	private String lugar;
	
	@Min(1) @Max(10)
	private int luzAmbiente;
	
	@Min(0) @Max(100)
	private int intensidad;
	
	private boolean estado;

}
