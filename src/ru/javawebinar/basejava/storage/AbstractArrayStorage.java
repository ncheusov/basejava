package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.exception.StorageException;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    @Override
    protected int getSize() {
        return size;
    }

    @Override
    protected final void updateResume(Resume resume) {
        storage[getIndex(resume.getUuid())] = resume;
    }

    @Override
    protected final void saveResume(Resume resume) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("ERROR: storage overflowed", resume.getUuid());
        } else {
            insertResume(resume);
            size++;
        }
    }

    @Override
    protected final void deleteResume(String uuid) {
        removeResume(getIndex(uuid));
        size--;
    }

    @Override
    protected void clearStorage() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    @Override
    protected Resume[] getAllResumes() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    protected final Resume getElement(String uuid) {
        return storage[getIndex(uuid)];
    }

    @Override
    protected abstract int getIndex(String uuid);

    protected abstract void insertResume(Resume resume);

    protected abstract void removeResume(int index);
}
