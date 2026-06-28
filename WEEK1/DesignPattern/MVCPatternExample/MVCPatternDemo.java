package MVCPatternExample;

public class MVCPatternDemo {

    public static void main(String[] args) {

        // Create Model
        Student student = new Student("Rahul", 101, "A");

        // Create View
        StudentView view = new StudentView();

        // Create Controller
        StudentController controller = new StudentController(student, view);

        // Display Initial Details
        System.out.println("Initial Student Details:");
        controller.updateView();

        // Update Student Details
        controller.setStudentName("Vineet");
        controller.setStudentId(102);
        controller.setStudentGrade("A+");

        System.out.println("\nUpdated Student Details:");
        controller.updateView();
    }
}