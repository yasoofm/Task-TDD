package com.letcode.SecureBankSystem.services.suggestions.functionalInterface;

import com.letcode.SecureBankSystem.bo.suggestions.CreateSuggestionRequest;

public interface ProcessSuggestions {
    void processSuggestion(CreateSuggestionRequest createSuggestionRequest);
}
