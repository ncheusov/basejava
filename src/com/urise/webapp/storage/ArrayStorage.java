package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */


public class ArrayStorage {

    private final Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        if (checkResume(resume.getUuid())) {
            for (int i = 0; i < size; i++) {
                if (resume.getUuid().equals(storage[i].getUuid())) {
                    storage[i].setUuid("update");
                }
            }
        } else {
            System.out.println(existsOrNot(resume.getUuid()));
        }
    }

    public void save(Resume resume) {
        if (storage.length < 10000) {
            if ((!checkResume(resume.getUuid()))) {
                storage[size] = resume;
                size++;
            } else {
                System.out.println(existsOrNot(resume.getUuid()));
            }
        } else {
            System.out.println("ERROR: storage overflowed");
        }

    }

    public Resume get(String uuid) {
        if (checkResume(uuid)) {
            for (int i = 0; i < size; i++) {
                if (checkResume(uuid)) {
                    return storage[i];
                }
            }
        }
        System.out.println(existsOrNot(uuid));
        return null;
    }

    public void delete(String uuid) {
        if (checkResume(uuid)) {
            int index = -1;
            for (int i = 0; i < size; i++) {
                if (checkResume(uuid)) {
                    index = i;
                    break;
                }
            }
            if (index > -1) {
                for (int i = index; i < size - 1; i++) {
                    storage[i] = storage[i + 1];
                }
                storage[--size] = null;
            }
        } else {
            System.out.println(existsOrNot(uuid));
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

    private boolean checkResume(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return true;
            }
        }
        return false;
    }

    private String existsOrNot(String uuid) {
        return (checkResume(uuid))
                ? "'" + uuid + "' has already exists"
                : "ERROR: '" + uuid + "' is not exists";
    }
}
