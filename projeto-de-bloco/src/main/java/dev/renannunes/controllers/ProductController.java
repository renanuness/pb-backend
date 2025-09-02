package dev.renannunes.controllers;

import dev.renannunes.model.Product;

import java.util.List;
import java.util.UUID;

public class ProductController extends BaseController<Product>{
    @Override
    public List<Product> get() {
        return List.of();
    }

    @Override
    public Product get(UUID id) {
        return null;
    }

    @Override
    public boolean post(Product entity) {
        return false;
    }

    @Override
    public boolean put(Product entity) {
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }
}
