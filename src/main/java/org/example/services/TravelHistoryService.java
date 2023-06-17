package org.example.services;

import org.example.entities.TravelHistory;
import org.example.utils.ConnectionFactory;
import org.example.repositories.TravelHistoryRepository;

import java.util.List;

public class TravelHistoryService {
    private final TravelHistoryRepository travelHistoryRepository = new TravelHistoryRepository(new ConnectionFactory());

    public TravelHistory getTravelHistoryById(Long id) {
        return travelHistoryRepository.get(id);
    }

    public List<TravelHistory> getListOfTravels(Long orderId) {
        return travelHistoryRepository.getListOfTravelsByOrderId(orderId);
    }

    public boolean saveTravelHistory(TravelHistory travelHistory) {
        return travelHistoryRepository.save(travelHistory);
    }
}
