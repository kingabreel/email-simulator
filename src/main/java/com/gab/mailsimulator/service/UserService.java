package com.gab.mailsimulator.service;

import com.gab.mailsimulator.model.User;
import com.gab.mailsimulator.repository.UserRepository;

public class UserService {

    private UserRepository userRepository;

    public UserService(){
        userRepository = new UserRepository();
    }

    public boolean checkUser(String email, String password) {
        if (userRepository.getUser(email) != null) {
            return userRepository.isLoginvalid(email, password);
        }
        return false;
    }

    public User getUser(String email) {
        return userRepository.getUser(email);
    }

    public void addUser(String mail, String password, String username) {
        User user = new User();
        user.setUserMail(mail);
        user.setPassword(password);
        user.setUsername(username);

        userRepository.addUser(user);
    }
}
