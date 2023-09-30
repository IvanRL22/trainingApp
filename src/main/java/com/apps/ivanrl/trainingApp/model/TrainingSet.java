package com.apps.ivanrl.trainingApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SETS")
@Getter
@Setter
public class TrainingSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "REPETITIONS")
    private int repetitions;

    @Column(name = "WEIGHT")
    private int weight;

    @ManyToOne
    @JoinColumn(name = "EXERCISE_ID")
    @JsonIgnore
    private Exercise exercise;

}
