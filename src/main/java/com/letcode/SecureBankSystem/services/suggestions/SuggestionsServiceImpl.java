package com.letcode.SecureBankSystem.services.suggestions;

import com.letcode.SecureBankSystem.bo.suggestions.CreateSuggestionRequest;
import com.letcode.SecureBankSystem.entities.GuestEntity;
import com.letcode.SecureBankSystem.repositories.GuestRepository;
import com.letcode.SecureBankSystem.services.suggestions.functionalInterface.ProcessSuggestions;
import com.letcode.SecureBankSystem.utils.enums.SuggestionStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class SuggestionsServiceImpl implements SuggestionsService{
    private final GuestRepository guestRepository;

    public SuggestionsServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public void createSuggestion(CreateSuggestionRequest createSuggestionRequest) {
        ProcessSuggestions function = suggestion -> {
            GuestEntity guestEntity = new GuestEntity();
            guestEntity.setSuggestionText(suggestion.getSuggestionText());
            guestEntity.setRate(suggestion.getRate());
            guestEntity.setStatus(SuggestionStatus.valueOf(suggestion.getStatus().toUpperCase()));
            guestRepository.save(guestEntity);
        };
    }

    @Override
    public List<GuestEntity> findSuggestions(String status) {
        List<GuestEntity> suggestions = guestRepository.findAll()
                .stream()
                .filter(guestEntity -> guestEntity.getStatus().toString().equals(status))
                .collect(Collectors.toList());
        return suggestions;
    }

    /*@Override
    public List<GuestEntity> findAllCreatedSuggestions() {
        List<GuestEntity> suggestions = guestRepository.findAllCreatedSuggestions().orElseThrow();
        return suggestions;
    }

    @Override
    public List<GuestEntity> findAllRemovedSuggestions() {
        List<GuestEntity> suggestions = guestRepository.findAllRemovedSuggestions().orElseThrow();
        return suggestions;
    }*/

}
