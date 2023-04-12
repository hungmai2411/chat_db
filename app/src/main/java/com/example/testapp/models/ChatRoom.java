package com.example.testapp.models;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ChatRoom {
    @PrimaryKey(autoGenerate = true)
    private long idChatRoom;

    public ChatRoom() {

    }

    public long getIdChatRoom() {
        return idChatRoom;
    }

    public void setIdChatRoom(long idChatRoom) {
        this.idChatRoom = idChatRoom;
    }

    @NonNull
    @Override
    public String toString() {
        return "idChatRoom: " + idChatRoom;
    }
}
