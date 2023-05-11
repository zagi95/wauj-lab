package hr.tvz.zagar.studapp.service;

import hr.tvz.zagar.studapp.dto.CourseDTO;
import hr.tvz.zagar.studapp.entity.Course;
import hr.tvz.zagar.studapp.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }
    @Override
    public List<CourseDTO> findAll() {
        return courseRepository.findAll().stream().map(this::mapCourseToDTO).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> findAllByStudentsJmbag(String jmbag) {
        return courseRepository.findAllByStudents_Jmbag(jmbag).stream().map(this::mapCourseToDTO).collect(Collectors.toList());
    }
    private CourseDTO mapCourseToDTO(Course course){
        return new CourseDTO(course.getName(), course.getEcts());
    }
}
