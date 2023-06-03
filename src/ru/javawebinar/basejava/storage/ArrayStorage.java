package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage extends AbstractArrayStorage {

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index > -1) {
            storage[index] = resume;
        } else {
            System.out.println("ERROR in method 'update': '" + resume.getUuid() + "' is not exists");
        }
    }

    public void save(Resume resume) {
        if (size > STORAGE_LIMIT) {
            System.out.println("ERROR: storage overflowed");
        } else if (getIndex(resume.getUuid()) > -1) {
            System.out.println("ERROR in method 'save': '" + resume.getUuid() + "' has already exists");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            storage[index] = storage[size - 1];
            size--;
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
}
