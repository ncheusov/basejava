package ru.javawebinar.basejava.model;

import java.util.*;

/**
 * Initial resume class
 */

public class Resume {

    // Unique identifier
    private final String uuid;
    private final String fullName;
    private final Map<String, String> contacts;

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
        contacts = new HashMap<>();
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(uuid, resume.uuid) && Objects.equals(fullName, resume.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName);
    }

    @Override
    public String toString() {
        return uuid + '(' + fullName + ')';
    }

    public class Contacts {

        public void add(String key, String value) {
            contacts.put(key, value);
        }

        public String get(String key) {
            return contacts.get(key);
        }

        public void update(String key, String value) {
            contacts.replace(key, value);
        }

        @Override
        public String toString() {
            return contacts.entrySet().toString();
        }
    }


}
