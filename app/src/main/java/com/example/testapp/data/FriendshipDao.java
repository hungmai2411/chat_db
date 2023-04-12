package com.example.testapp.data;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.testapp.models.User;

import java.util.List;

@Dao
public interface FriendshipDao {
    @Query("SELECT User.* FROM User JOIN Friendship ON User.sipUri = Friendship.friendSipUri WHERE Friendship.userSipUri = :userId")
    List<User> getFriendsForUser(String userId);

    @Query("INSERT INTO Friendship VALUES(:userSipUri,:friendSipUri)")
    void addFriend(String userSipUri, String friendSipUri);
}
