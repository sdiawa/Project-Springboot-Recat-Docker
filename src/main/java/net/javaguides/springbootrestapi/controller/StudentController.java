package net.javaguides.springbootrestapi.controller;

import net.javaguides.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    // http://localhost:8080/student
    @GetMapping("/student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(
                1,
                "Sekou",
                "Diawara",
                "Mali"
        );
        return ResponseEntity.ok()
                .header("custom-header", "sekou")
                .body(student);
    }

    // http://localhost:8080/students
    @GetMapping
    public ResponseEntity<List<Student>> getStudents()  {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Sekou", "Diawara", "Mali"));
        students.add(new Student(2, "Oumou", "Dembele", "Paris"));
        students.add(new Student(3, "Moctar", "Diawara", "France"));
        return ResponseEntity.ok(students);
    }

    // utiliser le path avec REST API
    // http://localhost:8080/students/1/Sekou/Diawara/Mali
    @GetMapping("/{id}/{firstName}/{lastName}/{adresse}")
    public ResponseEntity<Student>studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("firstName") String firstName,
                                       @PathVariable("lastName") String lastName,
                                       @PathVariable("adresse") String adresse) {
         Student student = new Student(studentId, firstName, lastName, adresse);
        return ResponseEntity.ok(student);
    }

    // utiliser le path avec REST API
    // http://localhost:8080/students/query?id=1&firstName=Sekou&lastName=Diawara&adresse=Mali
    @GetMapping("/query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName,
                                          @RequestParam String adresse) {
        Student student= new Student(id, firstName, lastName, adresse);
        return ResponseEntity.ok(student);

    }

    // REST API HTTP POST Request creating
    // http://localhost:8080/students/create
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        System.out.println(student.getAdresse());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
    // REST API HTTP POST Request update
    // http://localhost:8080/students/update
    @PostMapping("/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        System.out.println(student.getAdresse());
        return  ResponseEntity.ok(student);
    }

    // REST API HTTP POST Request remove
    // http://localhost:8080/students/update
    @DeleteMapping("/{id}/delete")
   public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Etudiant supprimer avec succès");
   }

}
