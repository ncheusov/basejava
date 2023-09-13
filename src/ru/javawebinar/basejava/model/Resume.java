package ru.javawebinar.basejava.model;

import java.util.*;

/**
 * Initial resume class
 */

public class Resume {

    // Unique identifier
    private final String uuid;
    private final String fullName;

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public class Contacts {

        private final Map<String, String> contacts = new HashMap<>();

        public Contacts(String phoneNumber, String mail, String skype) {
            contacts.put("Phone", Resume.this.phoneNumber = phoneNumber);
            contacts.put("Mail", Resume.this.mail = mail);
            contacts.put("Skype", Resume.this.skype = skype);
        }

        public String get(String contact) {
            return contacts.get(contact);
        }
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
}
