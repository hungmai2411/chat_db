package com.example.testapp.models;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class ChatRoomWithMessages {
    @Embedded public ChatRoom chatRoom;

    @Relation(
            parentColumn = "idChatRoom",
            entityColumn = "idChatRoom"
    )
    public List<Message> messages;


}
