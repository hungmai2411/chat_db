package com.example.testapp.models;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class UserWithChatRooms {
    @Embedded
    public User user;
    @Relation(
            parentColumn = "sipUri",
            entityColumn = "idChatRoom",
            associateBy = @Junction(ChatRoomUserCrossRef.class)
    )
    public List<ChatRoom> chatRooms;
}
