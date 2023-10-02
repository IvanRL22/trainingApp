package com.apps.ivanrl.trainingApp.service;

import com.apps.ivanrl.trainingApp.model.TrainingSession;
import com.apps.ivanrl.trainingApp.repository.TrainingSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingSessionFinderService {

    private final TrainingSessionRepository trainingSessionRepository;

    public TrainingSession findById(final Long trainingSessionId) {
        return this.trainingSessionRepository.findById(trainingSessionId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Session with id %d does not exist".formatted(trainingSessionId)));
    }

    public List<TrainingSession> getAll() {
        List<TrainingSession> allSessions = new ArrayList<>();
        this.trainingSessionRepository.findAll().forEach(allSessions::add);

        return allSessions;
    }
}
