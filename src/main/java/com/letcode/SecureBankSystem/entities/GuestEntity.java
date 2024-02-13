package com.letcode.SecureBankSystem.entities;

import javax.persistence.*;

@Entity
@Table
public class GuestEntity {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String suggestionText;

    private long rate;

    public GuestEntity(String suggestionText, long rate) {
        this.id = id;
        this.suggestionText = suggestionText;
        this.rate = rate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
