package com.guestbook.api.repository;

import org.springframework.stereotype.Repository;

@Repository
public class InfoRepository {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
