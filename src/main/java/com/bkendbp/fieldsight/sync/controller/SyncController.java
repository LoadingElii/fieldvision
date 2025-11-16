package com.bkendbp.fieldsight.sync.controller;

import com.bkendbp.fieldsight.sync.service.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sync")
public class SyncController {
    private final SyncService syncService;

    @Autowired
    public SyncController(SyncService syncService) {
        this.syncService = syncService;
    }

    @PostMapping("/refesh")
    public ResponseEntity<String> refreshGamesAndPredictions(@RequestBody String message) {
        syncService.archivePastGames();
        return new ResponseEntity<>(message,
                HttpStatus.valueOf(200));

    }
}