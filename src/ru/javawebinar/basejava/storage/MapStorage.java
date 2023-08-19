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
    protected int getSearchKey(Object searchKey) {
        return 0;
    }

    @Override
    protected void doUpdate(Object searchKey) {

    }

    @Override
    protected void doSave(Object searchKey, Resume resume) {

    }

    @Override
    protected void doDelete(Object searchKey) {

    }

    @Override
    protected void doClear() {

    }

    @Override
    protected Resume[] getAllResumes() {
        return new Resume[0];
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return null;
    }
}
