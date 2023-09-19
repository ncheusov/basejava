package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.Resume;

public class ResumeTestData {

    public static final Resume RESUME = new Resume("Grigory");
    public static final Resume.Contacts contacts = RESUME.new Contacts();

    public static void main(String[] args) {
        contacts.add("Тел.:", "+7(921) 855-0482");
        contacts.add("Skype:", "skype:grigory.kislin");
        contacts.add("Почта:", "gkislin@yandex.ru");
        contacts.add("LinkedIn", "https://www.linkedin.com/in/gkislin");
        contacts.add("GitHub", "https://github.com/gkislin?tab=overview&from=2023-09-01&to=2023-09-19");
        contacts.add("GitHub", "https://github.com/gkislin?tab=overview&from=2023-09-01&to=2023-09-19");
        System.out.println(contacts.get("Почта:"));
    }
}
