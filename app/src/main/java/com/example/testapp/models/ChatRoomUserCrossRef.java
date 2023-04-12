package com.example.testapp.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(primaryKeys = {"sipUri","idChatRoom"})
public class ChatRoomUserCrossRef {
    @NonNull
    public String sipUri;
    @NonNull
    public long idChatRoom;


    public ChatRoomUserCrossRef(@NonNull String sipUri, long idChatRoom) {
        this.sipUri = sipUri;
        this.idChatRoom = idChatRoom;
    }
}
