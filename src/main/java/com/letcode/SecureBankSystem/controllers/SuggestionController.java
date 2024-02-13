package com.letcode.SecureBankSystem.controllers;

import com.letcode.SecureBankSystem.bo.suggestions.CreateSuggestionRequest;
import com.letcode.SecureBankSystem.entities.GuestEntity;
import com.letcode.SecureBankSystem.services.suggestions.SuggestionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/get-create")
    public ResponseEntity<List<GuestEntity>> findCreateSuggestions(){
        List<GuestEntity> suggestions = suggestionsService.findAllCreatedSuggestions();
        return ResponseEntity.ok().body(suggestions);
    }

    @GetMapping("/get-remove")
    public ResponseEntity<List<GuestEntity>> findRemoveSuggestions(){
        List<GuestEntity> suggestions = suggestionsService.findAllRemovedSuggestions();
        return ResponseEntity.ok().body(suggestions);
    }
}
