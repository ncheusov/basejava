package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.List;

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
        storage[(int) searchKey] = resume;
    }

    @Override
    protected final void doSave(Object searchKey, Resume resume) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("ERROR: storage overflowed", resume.getUuid());
        } else {
            insertResume(resume, (int) searchKey);
            size++;
        }
    }

    @Override
    protected final void doDelete(Object searchKey) {
        removeResume((int) searchKey);
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
    protected List<Resume> doGetAll() {
        return Arrays.asList(storage).subList(0, size);
    }

    @Override
    protected final Resume doGet(Object searchKey) {
        return storage[(int) searchKey];
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return (int) searchKey >= 0;
    }

    @Override
    protected abstract Object getSearchKey(String uuid);

    protected abstract void insertResume(Resume resume, int searchKey);

    protected abstract void removeResume(int index);
}
