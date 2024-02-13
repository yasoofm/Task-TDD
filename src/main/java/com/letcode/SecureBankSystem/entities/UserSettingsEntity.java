package com.letcode.SecureBankSystem.entities;

import javax.persistence.*;

@Entity
@Table(name = "user_settings")
public class UserSettingsEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "receive_news_letter", nullable = false)
    private boolean receiveNewsLetter;

    @Column(name = "preferred_language", nullable = false)
    private String preferredLanguage;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isReceiveNewsLetter() {
        return receiveNewsLetter;
    }

    public void setReceiveNewsLetter(boolean receiveNewsLetter) {
        this.receiveNewsLetter = receiveNewsLetter;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }
}
