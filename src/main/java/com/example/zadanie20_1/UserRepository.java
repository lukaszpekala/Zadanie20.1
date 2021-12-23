package com.example.zadanie20_1;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> userList = new ArrayList<>();

    public UserRepository() {
        this.userList.add(new User("Adam", "Noga", 23));
        this.userList.add(new User("Ola", "Gut", 34));
        this.userList.add(new User("Marian", "Wrona", 56));
    }

    public List<User> getAll() {
        return userList;
    }

    public void add(User user) {
        userList.add(user);
    }
}
