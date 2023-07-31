package ru.javawebinar.basejava.storage;

import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.NotExistStorageException;
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
        assertNotNull(storage.getAll());
    }

    @Test
    public void update() {
        storage.update(new Resume(UUID_1));
    }

    @Test
    public void save() {

    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_1);
        assertNull(storage.get(UUID_1));
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void getAll() {
        Resume[] expected = new Resume[] {RESUME_1, RESUME_2, RESUME_3};
        Resume[] actual = storage.getAll();
        assertArrayEquals(expected, actual);
        assertEquals(3, storage.size());
        assertNotNull(actual);
    }

    @Test
    public void get() {
        assertEquals(storage.get(UUID_1), RESUME_1);
        assertEquals(storage.get(UUID_2), RESUME_2);
        assertEquals(storage.get(UUID_3), RESUME_3);
        assertNotNull(storage.get(UUID_1));
        assertNotNull(storage.get(UUID_2));
        assertNotNull(storage.get(UUID_3));
    }

    @Test (expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get(NOT_EXIST_RESUME);
    }
}
