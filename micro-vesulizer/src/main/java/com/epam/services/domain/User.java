package com.epam.services.domain;

import javax.persistence.*;

@Entity
@Table(name = "USR")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="USERNAME")
    private String user;
    @Column(name="MRSSAGE")
    private String message;

    public User() {
    }

    public User(Long id, String user, String message) {
        this.id = id;
        this.user = user;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
