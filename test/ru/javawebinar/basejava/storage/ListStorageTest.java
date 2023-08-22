package ru.javawebinar.basejava.storage;

import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.Assert.*;

public class ListStorageTest {

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final String NOT_EXIST_RESUME = "dummy";
    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final Resume RESUME_3 = new Resume(UUID_3);
    private static final Resume RESUME_4 = new Resume(UUID_4);
    private static final int EXPECTED_LEN = 3;
    private static final Storage STORAGE = new ListStorage();

    @Before
    public void setUp() {
        STORAGE.clear();
        STORAGE.save(RESUME_1);
        STORAGE.save(RESUME_2);
        STORAGE.save(RESUME_3);
    }

    @Test
    public void update() {
        STORAGE.update(RESUME_1);
        STORAGE.update(RESUME_2);
        STORAGE.update(RESUME_3);
    }

    @Test
    public void save() {
        STORAGE.save(RESUME_4);
        assertGet(RESUME_4);
        assertSize(EXPECTED_LEN + 1);
    }

    @Test
    public void delete() {
        String[] uuids = new String[] {UUID_1, UUID_2, UUID_3};
        int i = 1;
        for (String uuid : uuids) {
            STORAGE.delete(uuid);
            assertSize(EXPECTED_LEN - i);
            i++;
        }
    }

    @Test
    public void clear() {
        STORAGE.clear();
        final Resume[] expected = new Resume[0];
        final Resume[] actual = new Resume[STORAGE.size()];
        assertArrayEquals(expected, actual);
        assertSize(0);
    }

    @Test
    public void getAll() {
        final Resume[] expected = new Resume[] {RESUME_1, RESUME_2, RESUME_3};
        final Resume[] actual = STORAGE.getAll();
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
        STORAGE.update(new Resume(NOT_EXIST_RESUME));
    }

    @Test (expected = NotExistStorageException.class)
    public void getNotExist() {
        STORAGE.get(NOT_EXIST_RESUME);
    }

    @Test (expected = NotExistStorageException.class)
    public void deleteNotExist() {
        STORAGE.delete(NOT_EXIST_RESUME);
    }

    @Test (expected = ExistStorageException.class)
    public void saveExist() {
        final Resume[] resumes = new Resume[] {RESUME_1, RESUME_2, RESUME_3};
        for (Resume resume : resumes) {
            STORAGE.save(resume);
        }
    }

    private void assertSize(int size) {
        assertEquals(size, STORAGE.size());
    }

    private void assertGet(Resume resume) {
        assertEquals(resume, STORAGE.get(resume.getUuid()));
    }
}
