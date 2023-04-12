package com.example.testapp.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.testapp.models.Message;

import java.util.List;

@Dao
public interface MessageDao {


    @Query("Select * from Message")
    List<Message> getMessages();
}
