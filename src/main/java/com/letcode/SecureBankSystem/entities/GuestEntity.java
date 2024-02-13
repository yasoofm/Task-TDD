package com.letcode.SecureBankSystem.entities;

import com.letcode.SecureBankSystem.utils.enums.SuggestionStatus;

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

    @Enumerated(EnumType.STRING)
    private SuggestionStatus status;

    public SuggestionStatus getStatus() {
        return status;
    }

    public void setStatus(SuggestionStatus status) {
        this.status = status;
    }

    public GuestEntity(){}
    public GuestEntity(String suggestionText, long rate, SuggestionStatus status) {
        this.suggestionText = suggestionText;
        this.rate = rate;
        this.status = status;
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
