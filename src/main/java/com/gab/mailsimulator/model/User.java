package com.gab.mailsimulator.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String userMail;
    private String password;
    private List<Email> mainMailList;
    private List<Email> spamMailList;
    private List<Email> trashMailList;
    private List<Contact> contacts;

    public User(String username, String userMail, String password, List<Email> mainMailList, List<Email> spamMailList, List<Email> trashMailList, List<Contact> contacts) {
        this.username = username;
        this.userMail = userMail;
        this.password = password;
        this.mainMailList = mainMailList;
        this.spamMailList = spamMailList;
        this.trashMailList = trashMailList;
        this.contacts = contacts;
    }

    public User (){
        mainMailList = new ArrayList<>();
        spamMailList = new ArrayList<>();
        trashMailList = new ArrayList<>();
        contacts = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Email> getMainMailList() {
        return mainMailList;
    }

    public void setMainMailList(List<Email> mainMailList) {
        this.mainMailList = mainMailList;
    }

    public List<Email> getSpamMailList() {
        return spamMailList;
    }

    public void setSpamMailList(List<Email> spamMailList) {
        this.spamMailList = spamMailList;
    }

    public List<Email> getTrashMailList() {
        return trashMailList;
    }

    public void setTrashMailList(List<Email> trashMailList) {
        this.trashMailList = trashMailList;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
