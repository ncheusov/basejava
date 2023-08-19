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
    protected final void doUpdate(Object searchKey, Resume resume) {
        storage[(int) getSearchKey(resume.getUuid())] = (Resume) searchKey;
    }

    @Override
    protected final void doSave(Object searchKey) {
        Resume res = (Resume) searchKey;
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("ERROR: storage overflowed", res.getUuid());
        } else {
            insertResume((Resume) searchKey);
            size++;
        }
    }

    @Override
    protected final void doDelete(Object searchKey) {
        removeResume((int) getSearchKey(searchKey));
        size--;
    }

    @Override
    protected void doClear() {
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
    protected final Resume doGet(Object searchKey) {
        return storage[(int) getSearchKey((String) searchKey)];
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return getSearchKey(searchKey) != null;
    }

    @Override
    protected abstract Object getSearchKey(Object searchKey);

    protected abstract void insertResume(Resume resume);

    protected abstract void removeResume(int index);
}
