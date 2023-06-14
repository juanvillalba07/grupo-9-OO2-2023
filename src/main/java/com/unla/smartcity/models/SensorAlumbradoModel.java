package com.unla.smartcity.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class SensorAlumbradoModel extends DispositivoModel{
	
	private String lugar;
	private int luzAmbiente;
	private int intensidad;
	
}
