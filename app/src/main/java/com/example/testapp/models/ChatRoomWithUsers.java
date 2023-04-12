package com.example.testapp.models;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class ChatRoomWithUsers {
    @Embedded public ChatRoom chatRoom;
    @Relation(
            parentColumn = "idChatRoom",
            entityColumn = "sipUri",
            associateBy = @Junction(ChatRoomUserCrossRef.class)
    )
    public List<User> users;
}
