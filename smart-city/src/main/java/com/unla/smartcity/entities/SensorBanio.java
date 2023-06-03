package com.unla.smartcity.entities;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class SensorBanio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty
	private String edificio;

	@NotEmpty
	private String turno;

	@NotEmpty
	private String libre;

	@NotNull
	private LocalTime horaInicialLimpieza;

	@NotNull
	private LocalTime horaFinalLimpieza;

	public SensorBanio(String edificio, String turno, String libre, LocalTime horaInicialLimpieza,
			LocalTime horaFinalLimpieza) {
		super();
		this.edificio = edificio;
		this.turno = turno;
		this.libre = libre;
		this.horaInicialLimpieza = horaInicialLimpieza;
		this.horaFinalLimpieza = horaFinalLimpieza;
	}
}
