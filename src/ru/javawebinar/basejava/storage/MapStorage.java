package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class MapStorage extends AbstractStorage {

    private static final Map<String, Resume> STORAGE = new LinkedHashMap<>();

    @Override
    protected int getSize() {
        return STORAGE.size();
    }

    @Override
    protected void doUpdate(Object searchKey, Resume resume) {
        STORAGE.replace(resume.getUuid(), resume);
    }

    @Override
    protected void doSave(Object searchKey, Resume resume) {
        STORAGE.put(resume.getUuid(), resume);
    }

    @Override
    protected void doDelete(Object searchKey) {
        STORAGE.remove((String) searchKey);
    }

    @Override
    protected void doClear() {
        STORAGE.clear();
    }

    @Override
    protected Resume[] getAllResumes() {
        return STORAGE.values().toArray(new Resume[0]);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return STORAGE.get((String) searchKey);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    protected Object getSearchKey(String uuid) {
        for (String key : STORAGE.keySet()) {
            if (Objects.equals(key, uuid)) {
                return key;
            }
        }
        return null;
    }
}
