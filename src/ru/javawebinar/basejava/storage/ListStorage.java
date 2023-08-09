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
    protected void updateResume(Resume resume) {
        storage.add(getIndex(resume.getUuid()), resume);
    }

    @Override
    protected void saveResume(Resume resume) {
        storage.add(resume);
    }

    @Override
    protected void deleteResume(String uuid) {
        storage.remove(new Resume(uuid));
    }

    @Override
    protected void clearStorage() {
        storage.clear();
    }

    @Override
    protected Resume[] getAllResumes() {
        Resume[] resumes = new Resume[storage.size()];
        return storage.toArray(resumes);
    }

    @Override
    protected Resume getElement(String uuid) {
        return storage.get(getIndex(uuid));
    }

    @Override
    protected int getIndex(String uuid) {
        return storage.indexOf(new Resume(uuid));
    }
}
