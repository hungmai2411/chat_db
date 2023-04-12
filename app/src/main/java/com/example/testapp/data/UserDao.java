package com.example.testapp.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.testapp.models.ChatRoomWithUsers;
import com.example.testapp.models.User;
import com.example.testapp.models.UserWithChatRooms;

import java.util.List;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    @Transaction
    @Query("Select * from User where sipUri = :sipUri")
    List<UserWithChatRooms> getChatRoomsOfUser(String sipUri);
}
