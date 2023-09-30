package com.apps.ivanrl.trainingApp.controller;

import com.apps.ivanrl.trainingApp.model.TrainingSession;
import com.apps.ivanrl.trainingApp.service.CreateTrainingSessionService;
import com.apps.ivanrl.trainingApp.service.TrainingSessionFinderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/session")
@RequiredArgsConstructor
public class SessionController {

    private final CreateTrainingSessionService createTrainingSessionService;
    private final TrainingSessionFinderService trainingSessionFinderService;


    @PostMapping
    public TrainingSession addSession(@RequestBody TrainingSession newTrainingSession) {
        return this.createTrainingSessionService.createTrainingSession(newTrainingSession);
    }

    @GetMapping(value = "/{id}")
    public TrainingSession getSession(@PathVariable("id") final Long id) {
        return this.trainingSessionFinderService.findById(id);
    }

    @GetMapping(value = "/all")
    public List<TrainingSession> getAllSessions() {
        return this.trainingSessionFinderService.getAll();
    }

}
