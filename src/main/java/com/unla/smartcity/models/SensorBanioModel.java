package com.unla.smartcity.models;

import java.time.LocalTime;

import com.unla.smartcity.enums.Estado;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class SensorBanioModel extends DispositivoModel{

	private String edificio;

	private String turno;

	private LocalTime horaInicialLimpieza;

	private LocalTime horaFinalLimpieza;
	
	private Estado estado;
}
