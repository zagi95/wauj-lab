package hr.tvz.zagar.studapp.repository;

import hr.tvz.zagar.studapp.command.StudentCommand;
import hr.tvz.zagar.studapp.dto.StudentDTO;
import hr.tvz.zagar.studapp.entity.Student;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    List<Student> studentList = new ArrayList<>(Arrays.asList(
            new Student(1L,"mate", "miso", LocalDate.of(2000, 2, 22), "1234567890", 150),
            new Student(2L, "stipe", "stipic", LocalDate.of(1999, 1, 11), "1234567891", 155)
    )
    );
    @Override
    public List<Student> findAll() {
        return studentList;
    }
    @Override
    public Optional<Student> findStudentByJMBAG(String JMBAG) {
        return studentList.stream()
                .filter(student -> Objects.equals(student.getJmbag(), JMBAG))
                .findAny();
    }
    @Override
    public Optional<Student> save(Student student) {
        studentList.add(student);
        return Optional.of(student);
    }
    @Override
    public Optional<Student> updateStudentByJMBAG(Student student) {
        return this.studentList.stream()
                .filter(s -> s.getJmbag().equals(student.getJmbag()))
                .peek(s -> s.setEcts(student.getEcts()))
                .findAny();
    }

    @Override
    public void deleteByJMBAG(String JMBAG) {
        studentList.remove(findStudentByJMBAG(JMBAG).get());
    }
}
