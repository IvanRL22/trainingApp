package com.apps.ivanrl.trainingApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "EXERCISES")
@Getter
@Setter
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "EXERCISE_ID")
    private List<TrainingSet> sets;

    @ManyToOne
    @JoinColumn(name = "SESSION_ID", nullable = false)
    @JsonIgnore
    private TrainingSession trainingSession;

    @ManyToOne
    @JoinColumn(name = "MOVEMENT_ID", nullable = false)
    private Movement movement;

}
