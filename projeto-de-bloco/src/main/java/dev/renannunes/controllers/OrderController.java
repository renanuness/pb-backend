package dev.renannunes.controllers;

import dev.renannunes.model.Order;

import java.util.List;
import java.util.UUID;

public class OrderController extends BaseController<Order> {
    @Override
    public List<Order> get() {
        return List.of();
    }

    @Override
    public Order get(UUID id) {
        return null;
    }

    @Override
    public boolean post(Order entity) {
        return false;
    }

    @Override
    public boolean put(Order entity) {
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }
}
