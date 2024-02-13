package com.letcode.SecureBankSystem.services.suggestions;

import com.letcode.SecureBankSystem.bo.suggestions.CreateSuggestionRequest;

public interface SuggestionsService {
    void processSuggestion(CreateSuggestionRequest createSuggestionRequest);
}
