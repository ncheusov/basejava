package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.List;
import java.util.ArrayList;

/**
 * List based storage for Resumes
 */

public class ListStorage extends AbstractStorage {

    private static final List<Resume> storage = new ArrayList<>();

    @Override
    protected int getSize() {
        return storage.size();
    }

    protected void updateResume(Resume resume) {

    }

    @Override
    protected void saveResume(Resume resume) {

    }

    @Override
    protected void deleteResume(String uuid) {

    }

    @Override
    protected void clearStorage() {

    }

    @Override
    protected Resume[] getAllResumes() {
        return new Resume[0];
    }

    @Override
    protected Resume getElement(String uuid) {
        return null;
    }
}
