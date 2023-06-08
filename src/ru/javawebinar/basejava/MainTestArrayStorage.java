package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.storage.SortedArrayStorage;
import ru.javawebinar.basejava.storage.Storage;

/**
 * Test for ru.javawebinar.basejava.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {

    private static final Storage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        final Resume r1 = new Resume();
        r1.setUuid("uuid1");
        final Resume r2 = new Resume();
        r2.setUuid("uuid2");
        final Resume r3 = new Resume();
        r3.setUuid("uuid3");
        final Resume r4 = new Resume();
        r4.setUuid("uuid4");
        final Resume r5 = new Resume();
        r5.setUuid("uuid5");
        final Resume r6 = new Resume();
        r6.setUuid("uuid6");
        final Resume r7 = new Resume();
        r7.setUuid("uuid7");
        final Resume r8 = new Resume();
        r8.setUuid("uuid8");
        final Resume r9 = new Resume();
        r9.setUuid("uuid9");

        // unsorted storage
        ARRAY_STORAGE.save(r5);
        ARRAY_STORAGE.save(r3);
        ARRAY_STORAGE.save(r4);
        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r6);
        ARRAY_STORAGE.save(r8);
        ARRAY_STORAGE.save(r9);
        ARRAY_STORAGE.save(r7);

//        System.out.println("Insert sort " + Math.abs(Arrays.binarySearch(ARRAY_STORAGE.storage, 0, ARRAY_STORAGE.size(), r4) + 1));

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        ARRAY_STORAGE.delete(r4.getUuid());
        printAll();
        ARRAY_STORAGE.update(r1);
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    private static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
