package com.letcode.SecureBankSystem.bo.suggestions;

public class CreateSuggestionRequest {
    private String suggestionText;
    private long rate;

    public String getSuggestionText() {
        return suggestionText;
    }

    public void setSuggestionText(String suggestionText) {
        this.suggestionText = suggestionText;
    }

    public long getRate() {
        return rate;
    }

    public void setRate(long rate) {
        this.rate = rate;
    }
}
