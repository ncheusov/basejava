package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

public interface Storage {

    int size();

    void update(Resume resume);

    void save(Resume resume);

    void delete(String uuid);

    void clear();

    Resume[] getAll();

    Resume get(String uuid);
}
