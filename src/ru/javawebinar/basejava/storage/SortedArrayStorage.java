package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    public void binaryInsertingSort() {
        for (int i = 0; i < size; i++) {
            Resume searchKey = storage[i];
            int locationIndex = Math.abs(Arrays.binarySearch(storage, 0, i, searchKey) + 1);
            System.arraycopy(storage, locationIndex, storage, locationIndex + 1, i - locationIndex);
            storage[locationIndex] = searchKey;
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
