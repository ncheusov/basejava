package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected Object getSearchKey(Object searchKey) {
        for (int i = 0; i <= size; i++) {
            if (storage[i] != null) {
                if (searchKey.equals(storage[i].getUuid())) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    protected void insertResume(Resume resume, Object searchKey) {
        storage[size] = resume;
    }

    @Override
    protected void removeResume(int index) {
        storage[index] = storage[size - 1];
    }
}
