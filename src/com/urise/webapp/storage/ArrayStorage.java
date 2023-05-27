package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */


public class ArrayStorage {

    private static final int END_RANGE = 10000;
    private final Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        storage[getIndex(resume.getUuid())].setUuid("update");
    }

    public void save(Resume resume) {
        if (size < END_RANGE) {
            if (getIndex(resume.getUuid()) < 0) {
                storage[size] = resume;
                size++;
            } else {
                System.out.println("ERROR in method 'save': '" + resume.getUuid() + "' has already exists");
            }
        } else {
            System.out.println("ERROR: storage overflowed");
        }
    }

    public Resume get(String uuid) {
        if (getIndex(uuid) > -1) {
            return storage[getIndex(uuid)];
        }
        System.out.println("ERROR in method 'get': '" + uuid + "' is not exists");
        return null;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            for (int i = index; i < size - 1; i++) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
            }
        } else {
            System.out.println("ERROR in method 'delete': '" + uuid + "' is not exists");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i <= size; i++) {
            if (storage[i] != null) {
                if (uuid.equals(storage[i].getUuid())) {
                    return i;
                }
            }
        }
        return -1;
    }
}
