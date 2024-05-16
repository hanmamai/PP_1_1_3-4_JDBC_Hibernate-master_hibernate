package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        userService.createUsersTable();
        userService.saveUser("Иван", "Иванов", (byte) 19);
        userService.saveUser("Дмитрий", "Дмитриев", (byte) 20);
        userService.saveUser("Сергей", "Сергеев", (byte) 35);
        userService.saveUser("Влад", "Сидоров", (byte) 45);
        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
