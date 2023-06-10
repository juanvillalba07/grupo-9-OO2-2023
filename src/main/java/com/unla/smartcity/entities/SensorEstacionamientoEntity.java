package com.unla.smartcity.entities;

import com.unla.smartcity.enums.Estado;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SensorEstacionamientoEntity extends DispositivoEntity {
    @Column
    private Estado estado;
}
