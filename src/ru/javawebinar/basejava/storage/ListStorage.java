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
        STORAGE.add((Resume) searchKey);
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
    protected Resume[] getAllResumes() {
        Resume[] resumes = new Resume[STORAGE.size()];
        return STORAGE.toArray(resumes);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        int sk = (int) getSearchKey(searchKey);
        return STORAGE.get(sk);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return (int) getSearchKey(searchKey) > 0;
    }

    @Override
    protected Object getSearchKey(Object searchKey) {
        for (int i = 0; i < STORAGE.size(); i++) {
            if (STORAGE.get(i) != null) {
                if (STORAGE.get(i).getUuid().equals(searchKey)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
