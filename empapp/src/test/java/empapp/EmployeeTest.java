package empapp;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeTest {

    Employee employee;

    public EmployeeTest(){
        System.out.println("CONSTRUCTOR");
    }

    @BeforeAll
    static void beforeAll(){
        System.out.println("BEFORE ALL");
    }

    @BeforeEach
    void initEmployee(){
        employee = new Employee("John Doe", 1970);
        System.out.println("INIT");
    }

    @Test
    @Order(1)
    @DisabledOnOs(OS.WINDOWS)
    void testGetAge(){
        //Given
        //Employee employee = new Employee("John Doe", 1970);
        //When
        //int age = employee.getAge(2000);
        //Then
        //assertEquals(30, age);

        assertEquals(30, employee.getAge(2000));
        System.out.println("TC1");
    }

    @Test
    @Order(2)
    @Disabled("Until fix 123")
    void testGetAgeWithZero(){
        assertEquals(0,  employee.getAge(1970));
        System.out.println("TC2");
    }

}