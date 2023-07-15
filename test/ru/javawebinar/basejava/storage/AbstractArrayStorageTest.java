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
    private static final String UUID_4 = "uuid4";
    private final Storage storage;
//    private final Resume[] resumeArr = new Resume[];

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void size() {
        assertEquals(3, storage.size());
        assertNotNull(storage.getAll());
    }

    @Test
    public void update() {

    }

    @Test
    public void save() {
        Resume resume = new Resume(UUID_4);
        storage.save(resume);
        assertEquals(resume, storage.get(UUID_4));
        assertEquals(resume.getUuid(), "uuid4");
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_1);
        assertNull(storage.get(UUID_1));
    }

    @Test
    public void clear() {
        storage.clear();
        storage.getAll();
        assertEquals(0, storage.size());
    }

    @Test
    public void getAll() {
        storage.getAll();
        assertEquals(3, storage.size());
    }

    @Test
    public void get() {
        assertEquals(storage.get(UUID_1), storage.getAll()[0]);
        assertEquals(storage.get(UUID_2), storage.getAll()[1]);
        assertEquals(storage.get(UUID_3), storage.getAll()[2]);

    }

    @Test (expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }
}
