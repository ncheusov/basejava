package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    public final int size() {
        return getSize();
    }

    public final void update(Resume resume) {
        updateResume(resume);
    }

    public final void save(Resume resume) {
        saveResume(resume);
    }

    public final void delete(String uuid) {
        deleteResume(uuid);
    }

    public final void clear() {
        clearStorage();
    }

    public final Resume[] getAll() {
        return getAllResumes();
    }

    public final Resume get(String uuid) {
        return getElement(uuid);
    }

    protected abstract int getSize();

    protected abstract void updateResume(Resume resume);

    protected abstract void saveResume(Resume resume);

    protected abstract void deleteResume(String uuid);

    protected abstract void clearStorage();

    protected abstract Resume[] getAllResumes();

    protected abstract Resume getElement(String uuid);
}
