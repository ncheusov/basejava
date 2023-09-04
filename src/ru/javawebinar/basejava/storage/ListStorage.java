package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

/**
 * List based storage for Resumes
 */

public class ListStorage extends AbstractStorage {

    private static final List<Resume> STORAGE = new ArrayList<>();

    @Override
    protected int getSize() {
        return STORAGE.size();
    }

    @Override
    protected void doUpdate(Object searchKey, Resume resume) {
        STORAGE.add(resume);
    }

    @Override
    protected void doSave(Object searchKey, Resume resume) {
        STORAGE.add(resume);
    }

    @Override
    protected void doDelete(Object searchKey) {
        STORAGE.remove((int) searchKey);
    }

    @Override
    protected void doClear() {
        STORAGE.clear();
    }

    @Override
    protected List<Resume> doGetAll() {
        return new ArrayList<>(STORAGE);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return STORAGE.get((int) searchKey);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return (int) searchKey >= 0;
    }

    @Override
    protected Object getSearchKey(String uuid) {
        for (int i = 0; i < STORAGE.size(); i++) {
            if (STORAGE.get(i) != null && STORAGE.get(i).getUuid().equals(uuid)) return i;
        }
        return -1;
    }
}
