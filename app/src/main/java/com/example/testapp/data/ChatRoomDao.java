package com.example.testapp.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.testapp.models.ChatRoom;
import com.example.testapp.models.ChatRoomUserCrossRef;
import com.example.testapp.models.ChatRoomWithMessages;
import com.example.testapp.models.ChatRoomWithUsers;
import com.example.testapp.models.Message;

import java.util.List;
@Dao
public interface ChatRoomDao {
    @Insert
    long insertMessage(Message message);

    @Insert
    long insertChatRoom(ChatRoom chatRoom);

    @Insert
    void insertChatRoomUserCrossRef(ChatRoomUserCrossRef chatRoomUserCrossRef);

    @Transaction
    @Query("Select * from ChatRoom where idChatRoom = :idChatRoom")
    List<ChatRoomWithUsers> getUsersOfChatRoom(long idChatRoom);

    @Transaction
    @Query("Select * from ChatRoom where idChatRoom = :idChatRoom")
    List<ChatRoomWithMessages> getChatRoomWithMessages(long idChatRoom);
}
