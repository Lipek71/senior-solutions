package empapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testGetAge(){
        //Given
        Employee employee = new Employee("John Doe", 1970);
        //When
        int age = employee.getAge(2000);
        //Then
        assertEquals(30, age);

        //assertEquals(30, new Employee("John Doe", 1970).getAge(2000));
    }

}