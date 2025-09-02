package dev.renannunes.controllers;


import java.util.List;
import java.util.UUID;

public abstract class BaseController<T> {
    public abstract List<T> get();
    public abstract T get(UUID id);
    public abstract boolean post(T entity);
    public abstract boolean put(T entity);
    public abstract boolean delete(UUID id);
}
