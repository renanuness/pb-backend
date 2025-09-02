package dev.renannunes.controllers;

import dev.renannunes.model.User;

import java.util.List;
import java.util.UUID;

public class UserController extends BaseController<User>{
    @Override
    public List<User> get() {
        return List.of();
    }

    @Override
    public User get(UUID id) {
        return null;
    }

    @Override
    public boolean post(User entity) {
        return false;
    }

    @Override
    public boolean put(User entity) {
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }
}
