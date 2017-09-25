package com.example.demo.domain;

import javax.persistence.*;

/**
 * @author Pavel Gavrilov
 *         25.09.2017.
 */
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "message")
    private String message;

    public Message(String message) {
        this.message = message;
    }

    public Message() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
