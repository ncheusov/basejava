package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractStorage implements Storage {

    public int size() {
        return size;
    }

    public final void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index > -1) {
            storage[index] = resume;
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    public final void save(Resume resume) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("ERROR: storage overflowed", resume.getUuid());
        } else if (getIndex(resume.getUuid()) > -1) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            insertResume(resume);
            size++;
        }
    }

    public final void delete(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            removeResume(index);
            size--;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public final Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            return storage[index];
        }
        throw new NotExistStorageException(uuid);
    }
}
