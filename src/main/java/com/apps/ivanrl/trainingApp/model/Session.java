package com.apps.ivanrl.trainingApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "SESSIONS")
@Getter
@Setter
public class Session {

    @Id
    @Column(name = "ID")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE")
    private LocalDate date;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "session")
    private List<Exercise> exercises;
}
