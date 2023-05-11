package hr.tvz.zagar.studapp.service;

import hr.tvz.zagar.studapp.dto.CourseDTO;
import hr.tvz.zagar.studapp.entity.Course;

import java.util.List;
import java.util.Optional;


public interface CourseService {
    List<CourseDTO> findAll();
    List<CourseDTO> findAllByStudentsJmbag(String jmbag);
}
