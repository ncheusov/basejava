package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected Object getSearchKey(String uuid) {
        return Arrays.binarySearch(storage, 0, size, new Resume(uuid));
    }

    @Override
    protected void insertResume(Resume resume, int searchKey) {
        int insertIndex = Math.abs(Arrays.binarySearch(storage, 0, size, resume) + 1);
        System.arraycopy(storage, insertIndex, storage, insertIndex + 1, size - insertIndex);
        storage[insertIndex] = resume;
    }

    @Override
    protected void removeResume(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - 1);
    }
}
