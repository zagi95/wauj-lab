package hr.tvz.zagar.studapp.controller;

import hr.tvz.zagar.studapp.dto.CourseDTO;
import hr.tvz.zagar.studapp.dto.StudentDTO;
import hr.tvz.zagar.studapp.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("course")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses(){
        return courseService.findAll();
    }

    @GetMapping("/{jmbag}")
    public List<CourseDTO> getAllCoursesByStudentJmbag(@PathVariable String jmbag){
        return courseService.findAllByStudentsJmbag(jmbag);
    }

}
