package com.apps.ivanrl.trainingApp.service;

import com.apps.ivanrl.trainingApp.model.Movement;
import com.apps.ivanrl.trainingApp.model.TrainingSession;
import com.apps.ivanrl.trainingApp.repository.MovementRepository;
import com.apps.ivanrl.trainingApp.repository.TrainingSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CreateTrainingSessionService {

    private final TrainingSessionRepository trainingSessionRepository;
    private final MovementRepository movementRepository;

    public TrainingSession createTrainingSession(TrainingSession newTrainingSession) {
        newTrainingSession.getExercises().forEach(ex -> {
            Movement existingMovement = movementRepository.findById(ex.getMovement().getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                            "The movement with id %d does not exist".formatted(ex.getMovement().getId())));
            ex.setMovement(existingMovement);
            ex.setTrainingSession(newTrainingSession);
        });

        return this.trainingSessionRepository.save(newTrainingSession);
    }

}
