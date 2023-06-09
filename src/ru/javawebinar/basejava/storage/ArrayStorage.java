package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i <= size; i++) {
            if (storage[i] != null) {
                if (uuid.equals(storage[i].getUuid())) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    protected void insertResume(Resume resume) {
        storage[size] = resume;
    }

    @Override
    protected void removeResume(int index) {
        storage[index] = storage[size - 1];
    }
}
