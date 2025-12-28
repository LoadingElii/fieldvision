package com.bkendbp.fieldsight.sync.controller;

import com.bkendbp.fieldsight.sync.service.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/sync")
@CrossOrigin("localhost:8000")
public class SyncController {
    private final SyncService syncService;

    @Autowired
    public SyncController(SyncService syncService) {
        this.syncService = syncService;
    }

    @PostMapping("/refresh")
    public ResponseEntity<String> refreshGamesAndPredictions(@RequestBody String message) {
        syncService.archivePastGames();
        return ResponseEntity.ok(message);

    }
}