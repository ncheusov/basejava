package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private static final Map<String, Resume> STORAGE = new HashMap<>();

    @Override
    protected int getSize() {
        return STORAGE.size();
    }

    @Override
    protected void doUpdate(Object searchKey, Resume resume) {

    }

    @Override
    protected void doSave(Object searchKey, Resume resume) {
        STORAGE.put("uuid" + searchKey, resume);
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
        return STORAGE.get((String) searchKey);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return false;
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return null;
    }
}
