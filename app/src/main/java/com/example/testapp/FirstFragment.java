package com.example.testapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.testapp.data.TestDatabase;
import com.example.testapp.databinding.FragmentFirstBinding;
import com.example.testapp.models.ChatRoom;
import com.example.testapp.models.ChatRoomUserCrossRef;
import com.example.testapp.models.ChatRoomWithMessages;
import com.example.testapp.models.ChatRoomWithUsers;
import com.example.testapp.models.Friendship;
import com.example.testapp.models.Message;
import com.example.testapp.models.User;
import com.example.testapp.models.UserWithChatRooms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private User currentUser;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);

        currentUser = new User("sip:hung@suit-ims.dek.vn","hung","123456");
        TestDatabase.getInstance(getContext()).userDao().insertUser(currentUser);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnAddFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User friend = new User();
                String username = binding.edtUsername.getText().toString();
                String domain = binding.edtDomain.getText().toString();

                friend.setUsername(username);
                friend.setSipUri("sip:" + domain);
                TestDatabase.getInstance(getContext()).userDao().insertUser(friend);

                try {
                    TestDatabase.getInstance(getContext()).friendshipDao().addFriend(currentUser.getSipUri(), friend.getSipUri());
                    Toast.makeText(getContext(), "Add Friend successfully", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(getContext(), "Friend is existed", Toast.LENGTH_SHORT).show();
                }

            }
        });

        binding.btnGetFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<User> friends = TestDatabase.getInstance(getContext()).friendshipDao().getFriendsForUser(currentUser.getSipUri());
                Toast.makeText(getContext(), friends.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnGetMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Message> messages = TestDatabase.getInstance(getContext()).messageDao().getMessages();
                Toast.makeText(getContext(), messages.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create chat room
                ChatRoom chatRoom = new ChatRoom();
                long idChatRoom = TestDatabase.getInstance(getContext()).chatRoomDao().insertChatRoom(chatRoom);
                chatRoom.setIdChatRoom(idChatRoom);

                // create message
                Message message = new Message();
                message.setContent(binding.edtMessage.getText().toString());
                message.setCreatedAt("12/04/2023");
                message.setIdChatRoom(idChatRoom);
                message.setSenderSipUri(binding.edtUserReceive.getText().toString());
                long idMessage = TestDatabase.getInstance(getContext()).chatRoomDao().insertMessage(message);
                message.setIdMessage(idMessage);

                // create chat room user ref
                List<ChatRoomUserCrossRef> chatRoomUserRelations = Arrays.asList(
                  new ChatRoomUserCrossRef(currentUser.getSipUri(),idChatRoom),
                  new ChatRoomUserCrossRef(binding.edtUserReceive.getText().toString(),idChatRoom)
                );

                TestDatabase.getInstance(getContext()).chatRoomDao().insertChatRoomUserCrossRef(chatRoomUserRelations.get(0));
                TestDatabase.getInstance(getContext()).chatRoomDao().insertChatRoomUserCrossRef(chatRoomUserRelations.get(1));

                Toast.makeText(getContext(), "Add message successfully", Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnGetMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<ChatRoomWithMessages> chatRoomWithMessages = TestDatabase.getInstance(getContext()).chatRoomDao().getChatRoomWithMessages(1);
                Toast.makeText(getContext(),chatRoomWithMessages.get(0).messages.toString() , Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnGetUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<ChatRoomWithUsers> chatRoomWithUsers = TestDatabase.getInstance(getContext()).chatRoomDao().getUsersOfChatRoom(1);
                Toast.makeText(getContext(),chatRoomWithUsers.get(0).users.toString() , Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnGeChatRooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<UserWithChatRooms> userWithChatRooms = TestDatabase.getInstance(getContext()).userDao().getChatRoomsOfUser(currentUser.getSipUri());
                Toast.makeText(getContext(),userWithChatRooms.get(0).chatRooms.toString() , Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}