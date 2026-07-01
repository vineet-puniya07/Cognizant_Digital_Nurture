package employeeManagementSystem;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    void display() {
        System.out.println(employeeId + "\t" + name + "\t" + position + "\t" + salary);
    }
}

public class EmployeeManagementSystem {
    Employee[] employees;
    int size;
    int capacity;

    EmployeeManagementSystem(int capacity) {
        this.capacity = capacity;
        this.employees = new Employee[capacity];
        this.size = 0;
    }

    void addEmployee(int id, String name, String position, double salary) {
        if (size == capacity) {
            System.out.println("Array got full, Cannot add more employees.");
            return;
        }
        employees[size] = new Employee(id, name, position, salary);
        size++;
        System.out.println("Employee added: " + name);
    }

    Employee searchEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) {
                return employees[i];
            }
        }
        return null;
    }

    void traverseEmployees() {
        if (size == 0) {
            System.out.println("No employees to show.");
            return;
        }
        System.out.println("ID\tName\tPosition\tSalary");
        for (int i = 0; i < size; i++) {
            employees[i].display();
        }
    }

    void deleteEmployee(int id) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Employee not found");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[size - 1] = null;
        size--;
        System.out.println("Employee with ID " + id + " deleted.");
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);

        ems.addEmployee(101, "Vinit", "Developer", 45000);
        ems.addEmployee(102, "Gitesh", "Manager", 65000);
        ems.addEmployee(103, "Nikhil", "Tester", 38000);

        ems.traverseEmployees();

        Employee found = ems.searchEmployee(102);
        if (found != null) {
            System.out.println("Found: " + found.name);
        } else {
            System.out.println("Not found.");
        }

        ems.deleteEmployee(102);
        ems.traverseEmployees();
    }
}