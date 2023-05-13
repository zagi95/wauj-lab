package hr.tvz.zagar.studapp.repository;

import hr.tvz.zagar.studapp.command.StudentCommand;
import hr.tvz.zagar.studapp.dto.StudentDTO;
import hr.tvz.zagar.studapp.entity.Student;
import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    List<Student> findAll();
    Optional<Student> findStudentByJMBAG(String JMBAG);
    Optional<Student> save(Student student);

    Optional<Student> updateStudentByJMBAG(Student student);

    void deleteByJMBAG(String JMBAG);
}
