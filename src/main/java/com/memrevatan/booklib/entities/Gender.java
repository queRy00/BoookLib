package com.memrevatan.booklib.entities;

public enum Gender {
    MALE,FEMALE;

    public static Gender getGender(String name) {
        return name.toLowerCase().startsWith("f") ? FEMALE : MALE;
    }

    public Gender getFemale() {
        return FEMALE;
    }

    public Gender getMale() {
        return MALE;
    }
}
