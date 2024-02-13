package com.letcode.SecureBankSystem.entities;

import com.letcode.SecureBankSystem.utils.enums.Roles;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class RolesEntity {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private Roles title;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Roles getTitle() {
        return title;
    }

    public void setTitle(Roles title) {
        this.title = title;
    }
}
