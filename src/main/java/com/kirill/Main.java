package com.kirill;

import com.kirill.collectionTypes.ArrayCollection;

import java.util.Collection;

public class Main {

    public static void main(String[] args) {

        User user_1 = new User("Kirill", "12345");
        User user_2 = new User("Irina", "13123");

        Collection<User> userStorage = new ArrayCollection<>();
        userStorage.add(user_1);
        userStorage.add(user_2);

    }
}
