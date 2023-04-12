package com.example.testapp.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
  @ForeignKey(entity = User.class, parentColumns = "sipUri", childColumns = "senderSipUri")
})
public class Message {
    @PrimaryKey(autoGenerate = true)
    private long idMessage;

    private String content;
    private String createdAt;
    private String senderSipUri;
    private long idChatRoom;

    public Message(){}

    public Message(String content, String createdAt, String senderSipUri) {
        this.content = content;
        this.createdAt = createdAt;
        this.senderSipUri = senderSipUri;
    }

    public long getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(long idMessage) {
        this.idMessage = idMessage;
    }

    @NonNull
    @Override
    public String toString() {
        return senderSipUri + ": " + content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getSenderSipUri() {
        return senderSipUri;
    }

    public void setSenderSipUri(String senderSipUri) {
        this.senderSipUri = senderSipUri;
    }

    public long getIdChatRoom() {
        return idChatRoom;
    }

    public void setIdChatRoom(long idChatRoom) {
        this.idChatRoom = idChatRoom;
    }
}
