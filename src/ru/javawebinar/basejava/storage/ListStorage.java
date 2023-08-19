package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

/**
 * List based storage for Resumes
 */

public class ListStorage extends AbstractStorage {

    private static final List<Resume> storage = new ArrayList<>();

    @Override
    protected int getSize() {
        return storage.size();
    }

    @Override
    protected void doUpdate(Object searchKey) {
        storage.add(getSearchKey(searchKey.getUuid()), searchKey);
    }

    @Override
    protected void doSave(Object searchKey, Resume resume) {
        storage.add(searchKey);
    }

    @Override
    protected void doDelete(Object searchKey) {
        storage.remove(new Resume(searchKey));
    }

    @Override
    protected void doClear() {
        storage.clear();
    }

    @Override
    protected Resume[] getAllResumes() {
        Resume[] resumes = new Resume[storage.size()];
        return storage.toArray(resumes);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storage.get(getSearchKey(searchKey));
    }

    @Override
    protected int getSearchKey(Object searchKey) {
        return storage.indexOf(new Resume(searchKey));
    }
}
