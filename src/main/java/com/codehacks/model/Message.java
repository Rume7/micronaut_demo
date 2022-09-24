package com.codehacks.model;

import io.micronaut.core.annotation.Introspected;

import javax.persistence.*;

@Entity
@Introspected
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int code;
    private String s;

    public Message() {}

    public Message(int code, String s) {
        this.code = code;
        this.s = s;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
