package com.kirill;

public class Main {

    public static void main(String[] args) {

        User user_1 = new User("Kirill", "12345");
        User user_2 = new User("Irina", "13123");
        UserStorage userStorage = new UserStorage();

        userStorage.setUsers(user_1);
        userStorage.setUsers(user_2);

        for(User users : userStorage){

            System.out.format("\nUser name is: %s\n", users.getUserName());
        }
    }
}
