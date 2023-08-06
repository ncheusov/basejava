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
    private static final String UUID_4 = "uuid4";
    private static final String NOT_EXIST_RESUME = "dummy";
    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final Resume RESUME_3 = new Resume(UUID_3);
    private static final Resume RESUME_4 = new Resume(UUID_4);
    private static final Resume[] EMPTY_ARR = new Resume[0];
    private static final int EXPECTED_LEN = 3;
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
        assertSize(EXPECTED_LEN);
    }

    @Test
    public void update() {
        storage.update(RESUME_1);
        storage.update(RESUME_2);
        storage.update(RESUME_3);
    }

    @Test
    public void save() {
        storage.save(RESUME_4);
        assertGet(RESUME_4);
        assertSize(EXPECTED_LEN + 1);
    }

    @Test
    public void delete() {
        final String[] uuidsArr = new String[] {UUID_1, UUID_2, UUID_3};
        int i = 1;
        for (String uuid : uuidsArr) {
            storage.delete(uuid);
            assertSize(uuidsArr.length - i);
            i++;
        }
        assertArrayEquals(EMPTY_ARR, storage.getAll());
    }

    @Test
    public void clear() {
        storage.clear();
        final Resume[] actual = storage.getAll();
        assertArrayEquals(EMPTY_ARR, actual);
        assertSize(0);
    }

    @Test
    public void getAll() {
        final Resume[] expected = new Resume[] {RESUME_1, RESUME_2, RESUME_3};
        final Resume[] actual = storage.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void get() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test (expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(new Resume(NOT_EXIST_RESUME));
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
        final Resume[] resumes = new Resume[] {RESUME_1, RESUME_2, RESUME_3};
        for (Resume resume : resumes) {
            storage.save(resume);
        }
    }

    @Test (expected = StorageException.class)
    public void saveOverflow() {
        storage.clear();
        for (int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
            try {
                storage.save(new Resume());
            } catch (StorageException ex) {
                fail("ERROR: overflow ahead of time");
            }
        }
        storage.save(new Resume());
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }
}
