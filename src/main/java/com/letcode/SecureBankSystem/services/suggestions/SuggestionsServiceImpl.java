package com.letcode.SecureBankSystem.services.suggestions;

import com.letcode.SecureBankSystem.bo.suggestions.CreateSuggestionRequest;
import com.letcode.SecureBankSystem.entities.GuestEntity;
import com.letcode.SecureBankSystem.repositories.GuestRepository;
import com.letcode.SecureBankSystem.utils.enums.SuggestionStatus;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuggestionsServiceImpl implements SuggestionsService{
    private final GuestRepository guestRepository;

    public SuggestionsServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public void processSuggestion(CreateSuggestionRequest createSuggestionRequest) {
        GuestEntity guestEntity = new GuestEntity(createSuggestionRequest.getSuggestionText(), createSuggestionRequest.getRate(), SuggestionStatus.valueOf(createSuggestionRequest.getStatus().toUpperCase()));
        guestRepository.save(guestEntity);
    }

    @Override
    public List<GuestEntity> findAllCreatedSuggestions() {
        List<GuestEntity> suggestions = guestRepository.findAllCreatedSuggestions().orElseThrow();
        return suggestions;
    }

    @Override
    public List<GuestEntity> findAllRemovedSuggestions() {
        List<GuestEntity> suggestions = guestRepository.findAllRemovedSuggestions().orElseThrow();
        return suggestions;
    }

}
