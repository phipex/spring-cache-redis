package co.com.ies.cachejhip;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentResource {

    private final StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/student")
    public ResponseEntity<List<Student>> getAll(){
        return ResponseEntity.ok(studentService.getAll());
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Optional<Student>> find(@PathVariable("id") UUID id){
        return ResponseEntity.ok(studentService.findByID(id));
    }

    @PostMapping("/student")
    public ResponseEntity<Student> create(@RequestBody Student student){
        Student saved = studentService.save(student);

        return ResponseEntity.ok(saved);
    }

}

