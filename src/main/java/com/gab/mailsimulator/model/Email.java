package com.gab.mailsimulator.model;

import java.io.File;
import java.util.List;

public class Email {
    private String subject;
    private String sender;
    private String receiver;
    private List<String> cc;
    private String content;
    private List<File> attachments;

    public Email(String subject, String sender, String receiver, List<String> cc, String content){
        this.subject = subject;
        this.sender = sender;
        this.receiver = receiver;
        this.cc = cc;
        this.content = content;
    }
    public String getSubject() {
        return subject;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public List<String> getCc() {
        return cc;
    }

    public String getContent() {
        return content;
    }

    public List<File> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<File> attachments) {
        this.attachments = attachments;
    }
}
