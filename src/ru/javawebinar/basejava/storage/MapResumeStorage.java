package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage<Resume> {

    private static final Map<String, Resume> STORAGE = new HashMap<>();

    @Override
    protected int getSize() {
        return STORAGE.size();
    }

    @Override
    protected void doUpdate(Resume searchKey, Resume resume) {
        STORAGE.put(resume.getUuid(), resume);
    }

    @Override
    protected void doSave(Resume searchKey, Resume resume) {
        STORAGE.put(resume.getUuid(), resume);
    }

    @Override
    protected void doDelete(Resume searchKey) {
        STORAGE.remove(searchKey.getUuid());
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
    protected Resume doGet(Resume searchKey) {
        return STORAGE.get(searchKey.getUuid());
    }

    @Override
    protected boolean isExist(Resume searchKey) {
        return searchKey != null;
    }

    @Override
    protected Resume getSearchKey(String uuid) {
        return STORAGE.get(uuid);
    }
}
