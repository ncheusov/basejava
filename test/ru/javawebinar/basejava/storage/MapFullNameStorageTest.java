package ru.javawebinar.basejava.storage;

import org.junit.Test;

public class MapFullNameStorageTest extends AbstractStorageTest {

    private static final String FULL_NAME1 = "Samuel Joseph Fogarino";
    private static final String FULL_NAME2 = "Paul Julian Banks";
    private static final String FULL_NAME3 = "Daniel Alexander Kessler";
    private static final String FULL_NAME4 = "Jonathan Thomas Smith";
    private static final String NOT_EXIST_NAME = "Nancy Sandra Sinatra";

    public MapFullNameStorageTest() {
        super(new MapFullNameStorage());
    }

    @Override
    @Test
    public void setUp() {
        super.setUp();
    }

    @Override
    @Test
    public void update() {

    }

    @Override
    public void save() {
        super.save();
    }

    @Override
    public void delete() {
        super.delete();
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public void getAllSorted() {
        super.getAllSorted();
    }

    @Override
    public void get() {
        super.get();
    }

    @Override
    public void updateNotExist() {
        super.updateNotExist();
    }

    @Override
    public void getNotExist() {
        super.getNotExist();
    }

    @Override
    public void deleteNotExist() {
        super.deleteNotExist();
    }

    @Override
    public void saveExist() {
        super.saveExist();
    }
}
