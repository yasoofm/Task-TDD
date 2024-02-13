package com.letcode.SecureBankSystem.controllers;

import com.letcode.SecureBankSystem.bo.suggestions.CreateSuggestionRequest;
import com.letcode.SecureBankSystem.services.suggestions.SuggestionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/guest")
public class SuggestionController {
    private final SuggestionsService suggestionsService;

    public SuggestionController(SuggestionsService suggestionsService) {
        this.suggestionsService = suggestionsService;
    }

    @PostMapping("/create-suggestion")
    public ResponseEntity<Void> processSuggestion(@RequestBody CreateSuggestionRequest createSuggestionRequest){
        suggestionsService.processSuggestion(createSuggestionRequest);
        return ResponseEntity.ok().build();
    }
}
