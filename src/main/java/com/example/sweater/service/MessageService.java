package com.example.sweater.service;


import com.example.sweater.domain.Message;
import com.example.sweater.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepo messageRepo;

    public Iterable<Message>list(){
        return messageRepo.findAll();
    }

    public void add(String text,String tag){
        messageRepo.save(new Message(text,tag));
        return;
    }

    public List<Message> getMessageWithFilter(String filter){
        return messageRepo.findByTag(filter);
    }
}
