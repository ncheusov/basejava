package ru.javawebinar.basejava.model;

import java.util.*;

/**
 * Initial resume class
 */

public class Resume {

    // Unique identifier
    private final String uuid;
    private final String fullName;
    private final Map<ContactType, String> contacts;
    private final Map<SectionType, AbstractSection> sections;

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
        contacts = new HashMap<>();
        sections = new HashMap<>();
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

        public void add(ContactType key, String value) {
            contacts.put(key, value);
        }

        public String get(ContactType key) {
            return contacts.get(key);
        }

        public void update(ContactType key, String value) {
            contacts.replace(key, value);
        }
    }

    public abstract class AbstractSection {

        private final AbstractSection section;

        public AbstractSection(AbstractSection section) {
            this.section = section;
        }

//        protected abstract add(SectionType sectionType, )
    }

//    public class TextSection extends AbstractSection {
//
//    }

    public class ListSection {

        private final List<String> achievements = new ArrayList<>();
        private final List<String> qualification = new ArrayList<>();

        public void add(String descr) {
            achievements.add(descr);
        }


    }

    public class CompanySection {
        private Map<String, String> experience = new LinkedHashMap<>();
        private Map<String, String> education = new LinkedHashMap<>();
    }
}
