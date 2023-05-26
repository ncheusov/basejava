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
//            if (getIndex(resume.getUuid()) > -1) {
                storage[size] = resume;
                size++;
//            }
        } else {
            System.out.println("ERROR: storage overflowed");
        }
    }

    public Resume get(String uuid) {
        return (getIndex(uuid) > -1) ? storage[getIndex(uuid)] : null;
    }

    public void delete(String uuid) {
//        if (getIndex(uuid)) {
            int index = getIndex(uuid);
            if (index > -1) {
                for (int i = index; i < size - 1; i++) {
                    storage[i] = storage[i - 1];
                    storage[size - 1] = null;
                    size--;
                }
            }
//        } else {
//            System.out.println(existsOrNot(uuid));
//        }
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
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        System.out.println(existsOrNot(uuid));
        return -1;
    }

    private String existsOrNot(String uuid) {
        return (getIndex(uuid) > -1)
                ? "'" + uuid + "' has already exists"
                : "ERROR: '" + uuid + "' is not exists";
    }
}
