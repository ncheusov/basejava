package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapFullNameStorage extends AbstractStorage {

    private static final Map<String, Resume> STORAGE = new LinkedHashMap<>();

    @Override
    protected int getSize() {
        return 0;
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return null;
    }

    @Override
    protected void doUpdate(Object searchKey, Resume resume) {

    }

    @Override
    protected void doSave(Object searchKey, Resume resume) {

    }

    @Override
    protected void doDelete(Object searchKey) {

    }

    @Override
    protected void doClear() {

    }

    @Override
    protected List<Resume> getAllResumes(Comparator<Resume> resumeComparator) {
        return null;
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return null;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return false;
    }
}
