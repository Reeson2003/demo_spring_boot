package com.example.demo.service;

import com.example.demo.domain.Message;

import java.util.List;

/**
 * @author Pavel Gavrilov
 *         25.09.2017.
 */
public interface MessageService {
    void add(Message message);

    Message get(long id);

    void update(Message message);

    List<Message> getAll();

    void delete(long id);

    void perform();
}
