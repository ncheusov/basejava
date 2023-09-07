package ru.javawebinar.basejava.storage;

import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public abstract class AbstractStorageTest {

    protected final Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final String NOT_EXIST_UUID = "dummy";

/**
 *  Names like Paul, John, Alex etc. doesn't sort in {@link #getAllSorted}
 *  sorting by "name + any number" (by example Ivan22)
 */
    private static final String NAME_1 = "Name1";
    private static final String NAME_2 = "Name2";
    private static final String NAME_3 = "Name3";
    private static final String NAME_4 = "Name4";
    private static final String EMPTY_NAME = "";
    private static final Resume RESUME_1 = new Resume(UUID_1, NAME_1);
    private static final Resume RESUME_2 = new Resume(UUID_2, NAME_2);
    private static final Resume RESUME_3 = new Resume(UUID_3, NAME_3);
    private static final Resume RESUME_4 = new Resume(UUID_4, NAME_4);
    private static final List<Object> EMPTY_LIST = Collections.emptyList();
    protected static final int EXPECTED_LEN = 3;

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
        String[] uuids = new String[] {UUID_1, UUID_2, UUID_3};
        int i = 1;
        for (String uuid : uuids) {
            storage.delete(uuid);
            assertSize(EXPECTED_LEN - i);
            i++;
        }
        List<Resume> actual = storage.getAllSorted();
        assertEquals(EMPTY_LIST, actual);
    }

    @Test
    public void clear() {
        storage.clear();
        final List<Resume> actual = storage.getAllSorted();
        assertEquals(EMPTY_LIST, actual);
        assertSize(0);
    }

    @Test
    public void getAllSorted() {
        final List<Resume> actual = storage.getAllSorted();
        assertEquals(Arrays.asList(RESUME_1, RESUME_2, RESUME_3), actual);
    }

    @Test
    public void get() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(new Resume(NOT_EXIST_UUID, EMPTY_NAME));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get(NOT_EXIST_UUID);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(NOT_EXIST_UUID);
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
        assertEquals(resume, storage.get(resume.getUuid()));
    }
}
