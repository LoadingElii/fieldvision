package com.bkendbp.fieldsight.history.service;

import com.bkendbp.fieldsight.exception.ResourceNotFoundException;
import com.bkendbp.fieldsight.history.model.History;
import com.bkendbp.fieldsight.history.model.HistoryDto;
import com.bkendbp.fieldsight.history.repository.HistoryRepository;
import com.bkendbp.fieldsight.mapper.HistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {
    private final HistoryRepository historyRepository;

    @Autowired
    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

//    public HistoryDto getHistoricalGameByTeam(String team) {
//        History historicalGame = historyRepository.findHistoryByTeamName(team);
//        return HistoryMapper.toHistoryDto(historicalGame);
//    }

    public List<HistoryDto> getAllHistoricalGames() {
        List<History> Games = historyRepository.findAll();
        if (Games.isEmpty()) {
            throw new ResourceNotFoundException("No Historical Games Found.");
        }

        return Games.stream()
                .map(HistoryMapper::toHistoryDto).toList();
    }

    public void saveHistoricalGame(History pastGameAndPred) {
        historyRepository.save(pastGameAndPred);
    }
}
