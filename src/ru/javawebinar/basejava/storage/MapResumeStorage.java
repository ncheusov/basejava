package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage {

    private static final Map<String, Resume> STORAGE = new HashMap<>();

    @Override
    protected int getSize() {
        return STORAGE.size();
    }

    @Override
    protected void doUpdate(Object searchKey, Resume resume) {
        STORAGE.put(resume.getUuid(), resume);
    }

    @Override
    protected void doSave(Object searchKey, Resume resume) {
        STORAGE.put(resume.getUuid(), resume);
    }

    @Override
    protected void doDelete(Object searchKey) {
        STORAGE.remove(((Resume) searchKey).getUuid());
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
    protected Resume doGet(Object searchKey) {
        return STORAGE.get(((Resume) searchKey).getUuid());
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    protected Resume getSearchKey(String uuid) {
        return STORAGE.get(uuid);
    }
}
