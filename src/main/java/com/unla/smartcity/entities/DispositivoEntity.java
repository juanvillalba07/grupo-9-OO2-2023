package com.unla.smartcity.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class DispositivoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column
    @NotEmpty
    protected String nombre;

    @Column
    protected boolean activo;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="dispositivo")
    private Set<EventoEntity> eventos = new HashSet<>();
}
