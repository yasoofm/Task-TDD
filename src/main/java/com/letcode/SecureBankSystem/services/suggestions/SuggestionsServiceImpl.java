package com.letcode.SecureBankSystem.services.suggestions;

import com.letcode.SecureBankSystem.bo.suggestions.CreateSuggestionRequest;
import com.letcode.SecureBankSystem.entities.GuestEntity;
import com.letcode.SecureBankSystem.repositories.GuestRepository;
import org.springframework.stereotype.Service;

@Service
public class SuggestionsServiceImpl implements SuggestionsService{
    private final GuestRepository guestRepository;

    public SuggestionsServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public void processSuggestion(CreateSuggestionRequest createSuggestionRequest) {
        GuestEntity guestEntity = new GuestEntity(createSuggestionRequest.getSuggestionText(), createSuggestionRequest.getRate());
        guestRepository.save(guestEntity);
    }

}
