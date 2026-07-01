package taskManagementSystem;

import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
}

public class TaskManagementSystem {

    Task head;

    TaskManagementSystem() {
        head = null;
    }

    void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);

        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }
        System.out.println("Task added: " + name);
    }

    Task searchTask(int id) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == id) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task temp = head;
        System.out.println("ID\tName\tStatus");
        while (temp != null) {
            System.out.println(temp.taskId + "\t" + temp.taskName + "\t" + temp.status);
            temp = temp.next;
        }
    }

    void deleteTask(int id) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task " + id + " deleted.");
            return;
        }

        Task temp = head;
        while (temp.next != null && temp.next.taskId != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Task not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Task " + id + " deleted.");
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nTask Management System");
            System.out.println("1. Add task");
            System.out.println("2. Search task");
            System.out.println("3. Traverse tasks");
            System.out.println("4. Delete task");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter Task Id: ");
                int id = sc.nextInt();
                sc.nextLine(); // clear buffer
                System.out.print("Enter Task Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Status: ");
                String status = sc.nextLine();
                tms.addTask(id, name, status);

            } else if (choice == 2) {
                System.out.print("Enter Task ID to search: ");
                int id = sc.nextInt();
                Task found = tms.searchTask(id);
                if (found != null) {
                    System.out.println("Found: " + found.taskName + " - " + found.status);
                } else {
                    System.out.println("Task not found.");
                }

            } else if (choice == 3) {
                tms.traverseTasks();

            } else if (choice == 4) {
                System.out.print("Enter Task ID to delete: ");
                int id = sc.nextInt();
                tms.deleteTask(id);

            } else if (choice == 5) {
                System.out.println("Exiting...");

            } else {
                System.out.println("Invalid choice, Please make a valid choice");
            }

        } while (choice != 5);

    }
}
