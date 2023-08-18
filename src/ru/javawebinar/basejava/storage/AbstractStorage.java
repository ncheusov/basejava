package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.exception.NotExistStorageException;

public abstract class AbstractStorage implements Storage {

    public int size() {
        return getSize();
    }

    public final void update(Resume resume) {
        Object searchKey = resume;
        if (isExist(searchKey)) {
            updateResume(searchKey);
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    public final void save(Resume resume) {
        Object searchKey = getIndex(resume.getUuid());
        saveResume(getExistingSearchKey(searchKey));
    }

    public final void delete(String uuid) {
        Object searchKey = getIndex(uuid);
        getExistingSearchKey(searchKey);
        if () {
            deleteResume(uuid);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    public final void clear() {
        clearStorage();
    }

    public final Resume[] getAll() {
        return getAllResumes();
    }

    public final Resume get(String uuid) {
        if (getIndex(uuid) > -1) {
            return getElement(uuid);
        }
        throw new NotExistStorageException(uuid);
    }

    protected abstract int getSize();

    protected abstract boolean isExist(Resume resume);

    protected abstract int getIndex(String uuid);

    protected abstract void updateResume(Resume resume);

    protected abstract void saveResume(Resume resume);

    protected abstract void deleteResume(String uuid);

    protected abstract void clearStorage();

    protected abstract Resume[] getAllResumes();

    protected abstract Resume getElement(String uuid);

    private Object getExistingSearchKey(Object searchKey) {
        if (isExist((Resume) searchKey)) {
            throw new ExistStorageException(((Resume) searchKey).getUuid());
        }
        return searchKey;
    }
}
