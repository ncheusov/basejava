package ru.javawebinar.basejava.model;

import java.util.UUID;

/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    private final String uuid;

//    TODO: introduce fullName, getFullName
//    private final String fullName;


    public Resume() {
        this(UUID.randomUUID().toString());
    }
    public Resume(String uuid) {
        this.uuid = uuid;
//        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

//    public String getFullName() {
//        return fullName;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        return uuid.equals(resume.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public String toString() {
        return uuid;
    }
//
//     interface RandomName {
//
//        String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        Random rand = new Random();
//        Set<String> names = new HashSet<>();
//
//        default String randomIdentifier() {
//            StringBuilder builder = new StringBuilder();
//            while(builder.toString().isEmpty()) {
//                int length = rand.nextInt(5) + 5;
//                for(int i = 0; i < length; i++) {
//                    builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
//                }
//                if(names.contains(builder.toString())) {
//                    builder = new StringBuilder();
//                }
//            }
//            return builder.toString();
//        }
//    }
}
