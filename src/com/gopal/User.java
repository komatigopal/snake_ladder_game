package com.gopal;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int id;
    private final String name;
    private final List<String> history;
    private int position;

    public User(int id, String name) {
        super();
        this.id = id;
        this.name = name;
        this.position = 0;
        this.history = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getHistory() {
        return history;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", history=" + history + ", position=" + position + "]";
    }

}
