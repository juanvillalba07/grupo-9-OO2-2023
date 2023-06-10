package com.unla.smartcity.models;

import java.time.LocalTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class SensorBanioModel {
	private int id;

	private String edificio;

	private String turno;

	private String libre;

	private LocalTime horaInicialLimpieza;

	private LocalTime horaFinalLimpieza;
}
