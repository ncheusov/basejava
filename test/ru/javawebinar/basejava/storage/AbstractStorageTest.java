package ru.javawebinar.basejava.storage;

import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public abstract class AbstractStorageTest {

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final String NOT_EXIST_UUID = "dummy";
    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final Resume RESUME_3 = new Resume(UUID_3);
    private static final Resume RESUME_4 = new Resume(UUID_4);
    private static final Resume NOT_EXIST_RESUME = new Resume(NOT_EXIST_UUID);
    private static final Resume[] EMPTY_ARR = new Resume[0];
    protected static final int EXPECTED_LEN = 3;
    protected final Storage storage;

    protected AbstractStorageTest(Storage storage) {
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
        final Resume[] resumesArr = {RESUME_1, RESUME_2, RESUME_3};
        int i = 1;
        for (Resume resume : resumesArr) {
            storage.delete(resume);
            assertSize(resumesArr.length - i);
            i++;
        }
        Resume[] actual = storage.getAllSorted().toArray(new Resume[0]);
        assertArrayEquals(EMPTY_ARR, actual);
    }

    @Test
    public void clear() {
        storage.clear();
        final Resume[] actual = storage.getAllSorted().toArray(new Resume[0]);
        assertArrayEquals(EMPTY_ARR, actual);
        assertSize(0);
    }

    @Test
    public void getAllSorted() {
        final Resume[] expected = new Resume[]{RESUME_1, RESUME_2, RESUME_3};
        final Resume[] actual = storage.getAllSorted().toArray(new Resume[0]);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void get() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(new Resume(NOT_EXIST_UUID));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get(NOT_EXIST_RESUME);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(NOT_EXIST_RESUME);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        final Resume[] resumes = new Resume[]{RESUME_1, RESUME_2, RESUME_3};
        for (Resume resume : resumes) {
            storage.save(resume);
        }
    }

    protected void assertSize(int size) {
        assertEquals(size, storage.size());
    }

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume));
    }
}
