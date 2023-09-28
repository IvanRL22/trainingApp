package com.apps.ivanrl.trainingApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "EXERCISE")
@Getter
@Setter
public class Exercise {

    @Id
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "SESSION_ID")
    private Session session;
}
