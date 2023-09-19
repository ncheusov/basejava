package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.model.SectionType;

public class ResumeTestData {

    private static final String UUID = "11111111-1111-1111-1111";
    private static final String FULL_NAME = "Grigory";
    private static final String PHONE_NUMBER = "+7(921) 855-0482";
    private static final String SKYPE = "skype:grigory.kislin";
    private static final String EMAIl = "gkislin@yandex.ru";
    private static final Resume RESUME = new Resume(UUID, FULL_NAME);
    private static final Resume.Contacts contacts = RESUME.new Contacts(PHONE_NUMBER, EMAIl);
    private static final Resume.TextSection textSection = RESUME.new TextSection("Ведущий стажировок и " +
            "корпоративного обучения по Java Web и Enterprise технологиям", "Аналитический склад ума, сильная логика, креативность, инициативность." +
            " Пурист кода и архитектуры.");

    public static void main(String[] args) {
        contacts.add("Skype:", SKYPE);
        contacts.add("LinkedIn", "https://www.linkedin.com/in/gkislin");
        contacts.add("GitHub", "https://github.com/gkislin?tab=overview&from=2023-09-01&to=2023-09-19");
        contacts.add("GitHub", "https://github.com/gkislin?tab=overview&from=2023-09-01&to=2023-09-19");
        System.out.println(contacts.get("Почта:"));
        textSection.addObjective("Ведущий стажировок и " +
                "корпоративного обучения по Java Web и Enterprise технологиям");
        textSection.addPersonal("Аналитический склад ума, сильная логика, креативность, инициативность." +
                " Пурист кода и архитектуры.");
        System.out.println(textSection.get(SectionType.OBJECTIVE));
        System.out.println(textSection.get(SectionType.PERSONAL));
    }
}
