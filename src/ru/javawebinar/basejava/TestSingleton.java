package ru.javawebinar.basejava;

public class TestSingleton {

    private static TestSingleton INSTANCE;

    public static TestSingleton getInstance() {
        if (INSTANCE == null)
            INSTANCE = new TestSingleton();
        return INSTANCE;
    }

    private TestSingleton() {}

    public static void main(String[] args) {
        TestSingleton.getInstance().toString();
        Singleton instance = Singleton.valueOf("INSTANCE");
        System.out.println(instance.ordinal());
    }

    public enum Singleton {
        INSTANCE
    }
}
