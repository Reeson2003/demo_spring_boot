package com.example.demo.service;

import com.example.demo.domain.Message;
import com.example.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel Gavrilov
 *         25.09.2017.
 */
@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository repository;

    @Autowired
    public MessageServiceImpl(MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(Message message) {
        repository.save(message);
    }

    @Override
    public Message get(long id) {
        return repository.findOne(id);
    }

    @Override
    public void update(Message message) {
        repository.save(message);
    }

    @Override
    public List<Message> getAll() {
        List<Message> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    public void perform() {
        System.out.println("REPOSITORY = " + repository.getClass().getName());
    }
}
