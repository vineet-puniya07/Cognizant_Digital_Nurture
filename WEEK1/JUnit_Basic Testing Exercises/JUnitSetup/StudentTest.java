import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void testIsPass() {

        Student student = new Student();

        assertTrue(student.isPass(75));

    }

}