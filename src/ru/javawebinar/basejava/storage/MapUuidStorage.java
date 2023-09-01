package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.*;

/**
 * Map based storage for uniq identifier
 */

public class MapUuidStorage extends AbstractStorage {

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
        STORAGE.remove((String) searchKey);
    }

    @Override
    protected void doClear() {
        STORAGE.clear();
    }

    @Override
    protected List<Resume> doGetAllSorted(Comparator<Resume> resumeComparator) {
        List<Resume> resumeList = new ArrayList<>();
        for (Map.Entry<String, Resume> entry : STORAGE.entrySet()) {
            resumeList.add(entry.getValue());
        }
        resumeList.sort(resumeComparator);
        return resumeList;
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return STORAGE.get((String) searchKey);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return STORAGE.containsKey((String) searchKey);
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }
}
