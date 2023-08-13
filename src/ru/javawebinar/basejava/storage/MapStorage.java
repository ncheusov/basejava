package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MapStorage extends AbstractStorage {

    private static final Map<Resume, UUID> storage = new HashMap<>();

    @Override
    public int size() {
        return super.size();
    }

    @Override
    protected int getSize() {
        return 0;
    }

    @Override
    protected int getIndex(String uuid) {
        return 0;
    }

    @Override
    protected void updateResume(Resume resume) {

    }

    @Override
    protected void saveResume(Resume resume) {

    }

    @Override
    protected void deleteResume(String uuid) {

    }

    @Override
    protected void clearStorage() {

    }

    @Override
    protected Resume[] getAllResumes() {
        return new Resume[0];
    }

    @Override
    protected Resume getElement(String uuid) {
        return null;
    }
}
