package com.bkendbp.fieldsight.history.controller;

import com.bkendbp.fieldsight.history.model.HistoryDto;
import com.bkendbp.fieldsight.history.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/history")
public class HistoryController {
    private final HistoryService historyService;

    @Autowired
    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<HistoryDto>> getAllHistoricalGames(){
        return ResponseEntity.ok(historyService.getAllHistoricalGames());
    }

    @GetMapping("team/{teamName}")
    public ResponseEntity<HistoryDto> getHistoricalGame(@PathVariable("teamName") String teamName) {
        return ResponseEntity.ok(historyService.getHistoricalGameByTeam(teamName));
    }


}
