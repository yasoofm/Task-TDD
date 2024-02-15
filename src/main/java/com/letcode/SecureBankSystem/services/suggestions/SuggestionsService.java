package com.letcode.SecureBankSystem.services.suggestions;

import com.letcode.SecureBankSystem.bo.suggestions.CreateSuggestionRequest;
import com.letcode.SecureBankSystem.entities.GuestEntity;

import java.util.List;

public interface SuggestionsService {
    void createSuggestion(CreateSuggestionRequest createSuggestionRequest);

    List<GuestEntity> findSuggestions(String status);

/*    List<GuestEntity> findAllCreatedSuggestions();

    List<GuestEntity> findAllRemovedSuggestions();*/
}
