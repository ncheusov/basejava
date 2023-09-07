package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.*;

/**
 * Map based storage for uniq identifier
 */

public class MapUuidStorage extends AbstractStorage<String> {

    private static final Map<String, Resume> STORAGE = new HashMap<>();

    @Override
    protected int getSize() {
        return STORAGE.size();
    }

    @Override
    protected void doUpdate(String searchKey, Resume resume) {
        STORAGE.put(resume.getUuid(), resume);
    }

    @Override
    protected void doSave(String searchKey, Resume resume) {
        STORAGE.put(resume.getUuid(), resume);
    }

    @Override
    protected void doDelete(String searchKey) {
        STORAGE.remove(searchKey);
    }

    @Override
    protected void doClear() {
        STORAGE.clear();
    }

    @Override
    protected List<Resume> doGetAll() {
        return new ArrayList<>(STORAGE.values());
    }

    @Override
    protected Resume doGet(String searchKey) {
        return STORAGE.get(searchKey);
    }

    @Override
    protected boolean isExist(String searchKey) {
        return STORAGE.containsKey(searchKey);
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }
}
