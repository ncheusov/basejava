package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;

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

    }

    @Override
    protected void saveResume(Resume resume) {
        if (storage.contains(resume)) {
            throw new ExistStorageException(resume.getUuid());
        }
        storage.add(resume);
    }

    @Override
    protected void deleteResume(String uuid) {
        Resume resume = new Resume(uuid);
        if (!storage.contains(resume)) {
            throw new NotExistStorageException(uuid);
        }
        storage.remove(resume);
    }

    @Override
    protected void clearStorage() {
        storage.clear();
    }

    @Override
    protected Resume[] getAllResumes() {
        List<Resume> copyOfStorage = new ArrayList<>(storage);
        return copyOfStorage.toArray();
    }

    @Override
    protected Resume getElement(String uuid) {
        return null;
    }
}
