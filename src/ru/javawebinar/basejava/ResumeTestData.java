package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.ContactType;
import ru.javawebinar.basejava.model.Resume;

public class ResumeTestData {

    private static final String UUID = "11111111-1111-1111-1111";
    private static final String FULL_NAME = "Grigory";
    private static final String PHONE_NUMBER = "+79969347381";
    private static final String SKYPE = "skype:grigory.kislin";
    private static final String EMAIl = "gkislin@yandex.ru";
    private static final Resume RESUME = new Resume(UUID, FULL_NAME);
    private static final Resume.Contacts CONTACTS = RESUME.new Contacts();
//    private static final Resume.TextSection textSection = RESUME.new TextSection("Ведущий стажировок и " +
//            "корпоративного обучения по Java Web и Enterprise технологиям", "Аналитический склад ума, сильная логика, креативность, инициативность." +
//            " Пурист кода и архитектуры.");

    public static void main(String[] args) {
        CONTACTS.add(ContactType.EMAIL, EMAIl);
        System.out.println(CONTACTS.get(ContactType.EMAIL));
        CONTACTS.update(ContactType.EMAIL, "ncheusov@inbox.ru");
//        CONTACTS.add("LinkedIn", "https://www.linkedin.com/in/gkislin");
//        CONTACTS.add("GitHub", "https://github.com/gkislin?tab=overview&from=2023-09-01&to=2023-09-19");
//        CONTACTS.add("GitHub", "https://github.com/gkislin?tab=overview&from=2023-09-01&to=2023-09-19");

        System.out.println(CONTACTS.get(ContactType.PHONE_NUMBER));
        System.out.println(CONTACTS.get(ContactType.EMAIL));
//        textSection.addObjective("Ведущий стажировок и " +
//                "корпоративного обучения по Java Web и Enterprise технологиям");
//        textSection.addPersonal("Аналитический склад ума, сильная логика, креативность, инициативность." +
//                " Пурист кода и архитектуры.");
//        System.out.println(textSection.get(SectionType.OBJECTIVE));
//        System.out.println(textSection.get(SectionType.PERSONAL));
    }
}
