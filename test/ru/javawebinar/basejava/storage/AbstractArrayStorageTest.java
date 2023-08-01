package ru.javawebinar.basejava.storage;

import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String NOT_EXIST_RESUME = "dummy";
    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final Resume RESUME_3 = new Resume(UUID_3);
    private static final Resume[] EMPTY_ARR = new Resume[0];
    private static final Resume[] EXPECTED_ARR = new Resume[] {RESUME_1, RESUME_2, RESUME_3};
    private static final int LEN = EXPECTED_ARR.length;
    private static final int STORAGE_LIMIT = 10000;
    private final Storage storage;

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void size() {
        assertEquals(3, storage.size());
    }

    @Test (expected = NotExistStorageException.class)
    public void update() {
        storage.update(new Resume(NOT_EXIST_RESUME));
    }

    @Test
    public void save() {
        storage.clear();
        for (int i = 0; i < LEN; i++) {
            storage.save(EXPECTED_ARR[i]);
            assertEquals(EXPECTED_ARR[i], storage.getAll()[i]);
            assertEquals(i + 1, storage.size());
        }
        Resume[] actual = storage.getAll();
        assertArrayEquals(EXPECTED_ARR, actual);
    }

    @Test
    public void delete() {
        String[] uuidsArr = new String[] {UUID_1, UUID_2, UUID_3};
        int i = 1;
        for (String uuid : uuidsArr) {
            storage.delete(uuid);
            assertEquals(LEN - i, storage.size());
            i++;
        }
        assertArrayEquals(EMPTY_ARR, storage.getAll());
    }

    @Test
    public void clear() {
        storage.clear();
        Resume[] actual = storage.getAll();
        assertArrayEquals(EMPTY_ARR, actual);
        assertEquals(0, storage.size());
    }

    @Test
    public void getAll() {
        Resume[] actual = storage.getAll();
        assertArrayEquals(EXPECTED_ARR, actual);
        assertEqualsAll(actual);
        assertEquals(LEN, storage.size());
    }

    @Test
    public void get() {
        Resume[] actual = storage.getAll();
        assertEqualsAll(actual);
    }

    @Test (expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get(NOT_EXIST_RESUME);
    }

    @Test (expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(NOT_EXIST_RESUME);
    }

    @Test (expected = ExistStorageException.class)
    public void saveExist() {
        for (Resume resume : EXPECTED_ARR) {
            storage.save(resume);
        }
    }

    @Test
    public void storageOverflow() {
        storage.clear();
        for (int i = 0; i < STORAGE_LIMIT; i++) {
            try {
                storage.save(new Resume());
            } catch (StorageException ex) {
                fail("ERROR: overflow ahead of time");
            }
        }
    }

    private void assertEqualsAll(Resume[] actual) {
        for (int i = 0; i < LEN; i++) {
            assertEquals(EXPECTED_ARR[i], actual[i]);
        }
    }
}
