package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage {

    private static final Map<Resume, Resume> STORAGE = new HashMap<>();

    @Override
    protected int getSize() {
        return STORAGE.size();
    }

    @Override
    protected void doUpdate(Object searchKey, Resume resume) {
        STORAGE.put(resume, resume);
    }

    @Override
    protected void doSave(Object searchKey, Resume resume) {
        STORAGE.put(resume, resume);
    }

    @Override
    protected void doDelete(Object searchKey) {
        STORAGE.remove((Resume) searchKey);
    }

    @Override
    protected void doClear() {
        STORAGE.clear();
    }

    @Override
    protected List<Resume> doGetAll() {
        List<Resume> resumeList = new ArrayList<>(STORAGE.size());
        for (Map.Entry<Resume, Resume> entry : STORAGE.entrySet()) {
            resumeList.add(entry.getValue());
        }
        return resumeList;
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return STORAGE.get((Resume) searchKey);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    protected Resume getSearchKey(String uuid) {
        return STORAGE.get(new Resume(uuid, ""));
    }
}
