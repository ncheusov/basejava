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
    private final Map<SectionType, String> sections;

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

        public Contacts(String phoneNumber, String email) {
            contacts.put("Тел:", phoneNumber);
            contacts.put("Почта:", email);
        }

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

    public class TextSection {

        public TextSection(String objective, String personal) {
            sections.put(SectionType.OBJECTIVE, objective);
            sections.put(SectionType.PERSONAL, personal);
        }

        public void addObjective(String description) {
            sections.put(SectionType.OBJECTIVE, description);
        }

        public void addPersonal(String description) {
            sections.put(SectionType.PERSONAL, description);
        }

        public String get(SectionType key) {
            return sections.get(key);
        }
    }

    public class AchievementQualificationSection {

        private final List<String> achievements = new ArrayList<>();
        private final List<String> qualification = new ArrayList<>();

        public void add(String descr) {
            achievements.add(descr);
        }


    }

    public class ExperienceEducationSection {

        private String position;
        private String organization;
        private String date;
        private String responsibilities;
        private String grade;
        private Map<String, String> experience = new LinkedHashMap<>();
        private Map<String, String> education = new LinkedHashMap<>();
    }
}
