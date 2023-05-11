package hr.tvz.zagar.studapp.service;

import hr.tvz.zagar.studapp.dto.StudentDTO;
import hr.tvz.zagar.studapp.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<StudentDTO> findAll();
    Optional<StudentDTO> findStudentByJMBAG(String JMBAG);
    Optional<StudentDTO> updateStudentByJmbag(Student student);
    Optional<StudentDTO> save( Student student);
    void deleteByJmbag(String JMBAG);
}
