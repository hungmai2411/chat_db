package com.example.testapp.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.testapp.models.ChatRoom;
import com.example.testapp.models.ChatRoomUserCrossRef;
import com.example.testapp.models.Friendship;
import com.example.testapp.models.Message;
import com.example.testapp.models.User;

@Database(entities = {User.class, Friendship.class, Message.class, ChatRoom.class, ChatRoomUserCrossRef.class}, version = 1)
public abstract class TestDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "test.db";
    private static TestDatabase instance;

    public static synchronized TestDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), TestDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries().build();
        }

        return instance;
    }

    public abstract FriendshipDao friendshipDao();
    public abstract UserDao userDao();
    public abstract MessageDao messageDao();

    public abstract ChatRoomDao chatRoomDao();

}
