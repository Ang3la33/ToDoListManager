import models.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ToDoListCLI {

    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {
        boolean isRunning = false;
        while (isRunning) {
            System.out.println();
            System.out.println("Welcome to the To-Do List Manager");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("1. Add User");
            System.out.println("2. Add Task to User");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. View all Tasks for a User");
            System.out.println("5. Exit");
            System.out.println("Please choose an option:");

            String input = scanner.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> addUser();
                case 2 -> addTaskToUser();
                case 3 -> markTaskAsCompleted();
                case 4 -> viewUsersTasks();
                case 5 -> {
                    isRunning = false;
                    System.out.println("Thank you for using the To-Do List Manager!");
                }
                default -> System.out.println("Invalid choice: Please choose a valid option 1-5");
            }
        }
    }

    private static void addUser() {
        System.out.println("Please enter a user name:");
        String userName = scanner.nextLine().trim();

        if (userName.isEmpty()) {
            System.out.println("Username cannot be empty");
            return;
        }

        for (User user : users) {
            if (user.getUserName().equalsIgnoreCase(userName)) {
                System.out.println("Username is already in use");
                return;
            }
        }

        User newUser = new User(userName);
        users.add(new User(newUser));
        System.out.println("User " + newUser.getUserName() + " with ID " + newUser.getUserID() + " successfully added.");

    }

    private static User getUserByName() {
        System.out.println("Enter the user name: ");
        String userName = scanner.nextLine().trim();
        for (User user : users) {
            if (user.getUserName().equalsIgnoreCase(userName)) {
                return user;
            }
        }
        System.out.println("User not found.");
        return null;
    }

    private static void addTaskToUser() {
        User user = getUserByName();
    }

}
