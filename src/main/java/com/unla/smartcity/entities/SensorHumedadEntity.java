package com.unla.smartcity.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table (name = "sensor_humedad")
public class SensorHumedadEntity extends DispositivoEntity {
    @Column (name="humedad_actual")
    @NotNull @Min(1) @Max(100)
    private int humedadActual;

    @Column (columnDefinition = "BOOLEAN")
    private boolean estado;

    @Column (name="createdat", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column (name="updatedat")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
