package com.unla.smartcity.entities;

import java.time.LocalTime;

import com.unla.smartcity.enums.Estado;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class SensorBanioEntity extends DispositivoEntity{
	@NotEmpty
	private String edificio;

	@NotEmpty
	private String turno;

	@NotNull
	private LocalTime horaInicialLimpieza;

	@NotNull
	private LocalTime horaFinalLimpieza;

	@Column
    private Estado estado;

	
	
	
}
