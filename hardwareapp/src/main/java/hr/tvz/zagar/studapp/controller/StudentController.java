package hr.tvz.zagar.studapp.controller;

import hr.tvz.zagar.studapp.command.StudentCommand;
import hr.tvz.zagar.studapp.dto.StudentDTO;
import hr.tvz.zagar.studapp.entity.Student;
import hr.tvz.zagar.studapp.service.StudentService;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping()
    public List<StudentDTO> getAllStudents(){
        return studentService.findAll();
    }

    @GetMapping("/{JMBAG}")
    public ResponseEntity<StudentDTO> getStudentByJMBAG(@PathVariable final String JMBAG){
        return studentService.findStudentByJMBAG(JMBAG)
                .map(
                        studentDTO -> ResponseEntity
                                .status(HttpStatus.OK)
                                .body(studentDTO)
                ).orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.NO_CONTENT)
                                .build()
                );
    }
    @PostMapping
    public ResponseEntity<StudentDTO> save(@Valid @RequestBody final StudentCommand command){
        return studentService.save(new Student(
                    null,
                        command.getFirstName(),
                        command.getLastName(),
                        command.getDateOfBirth(),
                        command.getJmbag(),
                        command.getNumberOfECTS()
                ))
                .map(
                        studentDto -> ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(studentDto)
                )
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .build()
                );
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{JMBAG}")
    public void deleteByJMBAG(@PathVariable String JMBAG){
        studentService.deleteByJmbag(JMBAG);
    }
    @PutMapping("/{JMBAG}")
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentCommand command){
        return studentService.updateStudentByJmbag(new Student(
                null,
                    command.getFirstName(),
                    command.getLastName(),
                    command.getDateOfBirth(),
                    command.getJmbag(),
                    command.getNumberOfECTS())
                )
                .map(
                        studentDTO -> ResponseEntity
                                .status(HttpStatus.ACCEPTED)
                                .body(studentDTO)
                ).orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.NO_CONTENT)
                                .build()
                );
    }
}
