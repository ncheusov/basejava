package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.*;

public class MapFullNameStorage extends AbstractStorage {

    private static final Map<String, Resume> STORAGE = new HashMap<>();

    @Override
    protected int getSize() {
        return STORAGE.size();
    }

    @Override
    protected void doUpdate(Object searchKey, Resume resume) {
        STORAGE.put(resume.getFullName(), resume);
    }

    @Override
    protected void doSave(Object searchKey, Resume resume) {
        STORAGE.put(resume.getFullName(), resume);
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
        List<Resume> resumeList = new ArrayList<>(STORAGE.size());
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
    protected Object getSearchKey(String fullName) {
        for (String key : STORAGE.keySet()) {
            if (key.equals(fullName)) {
                return fullName;
            }
        }
        return null;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return STORAGE.containsKey((String) searchKey);
    }
}
