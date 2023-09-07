package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

/**
 * List based storage for Resumes
 */

public class ListStorage extends AbstractStorage<Integer> {

    private static final List<Resume> STORAGE = new ArrayList<>();

    @Override
    protected int getSize() {
        return STORAGE.size();
    }

    @Override
    protected void doUpdate(Integer searchKey, Resume resume) {
        STORAGE.add(resume);
    }

    @Override
    protected void doSave(Integer searchKey, Resume resume) {
        STORAGE.add(resume);
    }

    @Override
    protected void doDelete(Integer searchKey) {
        STORAGE.remove(searchKey.intValue());
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
    protected Resume doGet(Integer searchKey) {
        return STORAGE.get(searchKey);
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey >= 0;
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < STORAGE.size(); i++) {
            if (STORAGE.get(i) != null && STORAGE.get(i).getUuid().equals(uuid)) return i;
        }
        return -1;
    }
}
