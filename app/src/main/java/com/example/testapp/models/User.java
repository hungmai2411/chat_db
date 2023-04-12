package com.example.testapp.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    private @NonNull String sipUri;

    private String username;
    private String password;

    public User() {
    }

    public User(@NonNull String sipUri, String username, String password) {
        this.sipUri = sipUri;
        this.username = username;
        this.password = password;
    }

    public String getSipUri() {
        return sipUri;
    }

    public void setSipUri(String sipUri) {
        this.sipUri = sipUri;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NonNull
    @Override
    public String toString() {
        return sipUri;
    }
}
