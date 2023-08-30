package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertResume(Resume resume, int searchKey) {
        storage[size] = resume;
    }

    @Override
    protected void removeResume(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected Object getSearchKey(String key) {
        for (int i = 0; i < size; i++) {
            if (storage[i] != null) {
                if (key.equals(storage[i].getUuid())) {
                    return i;
                }
            }
        }
        return -1;
    }
}
