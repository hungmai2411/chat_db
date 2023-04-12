package com.example.testapp.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(primaryKeys = {"userSipUri","friendSipUri"},
        foreignKeys = {
                @ForeignKey(entity = User.class, parentColumns = "sipUri", childColumns = "userSipUri"),
                @ForeignKey(entity = User.class, parentColumns = "sipUri", childColumns = "friendSipUri")
        })
public class Friendship {
    private @NonNull String userSipUri;
    private @NonNull String friendSipUri;

    public Friendship(){

    }

    @NonNull
    public String getUserSipUri() {
        return userSipUri;
    }

    public void setUserSipUri(@NonNull String userSipUri) {
        this.userSipUri = userSipUri;
    }

    @NonNull
    public String getFriendSipUri() {
        return friendSipUri;
    }

    public void setFriendSipUri(@NonNull String friendSipUri) {
        this.friendSipUri = friendSipUri;
    }
}
