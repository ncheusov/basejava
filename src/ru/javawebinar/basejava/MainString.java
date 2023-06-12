package ru.javawebinar.basejava;

public class MainString {

    public static void main(String[] args) {
        String[] strArr = new String[] {"1", "2", "3", "4", "5"};
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str).append(", ");
        }
        System.out.println(sb);
    }
}
