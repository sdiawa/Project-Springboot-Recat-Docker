package net.javaguides.springbootrestapi.controller;

import net.javaguides.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    //http:localhost:8080/student
    @GetMapping("/student")
    public Student getStudent() {
        Student student = new Student(
                1,
                "Sekou",
                "Diawara",
                "Mali"
        );
        return student;
    }

    //http:localhost:8080/students
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Sekou", "Diawara", "Mali"));
        students.add(new Student(2, "Oumou", "Dembele", "Paris"));
        students.add(new Student(3, "Moctar", "Diawara", "France"));
        return students;
    }
    //utiliser le path avec rest API
    //http:localhost:8080/students/1/Sekou/Diawara/Mali

    @GetMapping("/students/{id}/{first-name}/{last-name}/{adresse}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName,
                                       @PathVariable("adresse") String adresse) {
        return new Student(studentId, firstName, lastName, adresse);

    }

    //utiliser le path avec rest API
    //http:localhost:8080/students/query?id=1&firstName=Sekou&lastName=Diawara&adresse=Mali

    @GetMapping("/students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName,
                                          @RequestParam String adresse) {
        return new Student(id, firstName, lastName, adresse);

    }

    // REST API HTTP POST Request
    //@PostMapping et @RequestBody
    @PostMapping("Students/create")
    public Student createStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }
}

