package com.example.demo.controller;

import com.example.demo.domain.Message;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Pavel Gavrilov
 *         25.09.2017.
 */
@RestController
public class MessageController {
    private final MessageService service;

    @Autowired
    public MessageController(MessageService service) {
        this.service = service;
    }

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public Message demoController() {
        service.perform();
        return new Message("Hello world");
    }

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public List<Message> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public void add(@RequestParam("data") String message) {
        service.add(new Message(message));
    }

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public Message get(@RequestParam("id") long id) {
        return service.get(id);
    }

//    @RequestMapping(value = "/message", method = RequestMethod.PUT)
//    public void update(@RequestParam("data") String message, @RequestParam("id") long id) {
//        Message m = service.get(id);
//        if (m != null) {
//            m.setMessage(message);
//            service.update(m);
//        }
//    }

    @RequestMapping(value = "/message", method = RequestMethod.PUT)
    @ResponseBody
    public void update(@RequestBody() Message message) {
        service.update(message);
    }

    @RequestMapping(value = "/message", method = RequestMethod.DELETE)
    public void delete(@RequestParam("id") long id) {
        service.delete(id);
    }
}
