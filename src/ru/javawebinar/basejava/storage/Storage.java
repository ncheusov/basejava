package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.List;

public interface Storage {

    int size();

    void update(Resume resume);

    void save(Resume resume);

    void delete(String uuid);

    void clear();

    List<Resume> getAllSorted();

    Resume get(String uuid);
}
