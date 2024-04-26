package com.gab.mailsimulator.repository;


import com.gab.mailsimulator.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class UserRepository {
    private HashMap<String, String> usersMail;
    private List<User> usersList;

    public UserRepository(){
        usersMail = new HashMap<>();
        usersList = new ArrayList<>();
    }

    public boolean isLoginvalid(String email, String password) {
        return Objects.equals(usersMail.get(email), password);
    }
    public void addUser(User user) {
        usersMail.put(user.getUserMail(), user.getPassword());
        usersList.add(user);
    }

    public void removeUser(String email) {
        usersMail.remove(email);
        usersList.removeIf(u -> u.getUserMail().equalsIgnoreCase(email));
    }

    public User getUser(String email) {
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).getUserMail().equalsIgnoreCase(email)) {
                return usersList.get(i);
            }
        }
        return null;
    }
}
