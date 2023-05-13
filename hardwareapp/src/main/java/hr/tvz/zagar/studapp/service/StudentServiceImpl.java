package hr.tvz.zagar.studapp.service;

import hr.tvz.zagar.studapp.dto.StudentDTO;
import hr.tvz.zagar.studapp.entity.Student;
import hr.tvz.zagar.studapp.repository.JdbcStudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final JdbcStudentRepository studentRepository;

    public StudentServiceImpl(JdbcStudentRepository repository){
        this.studentRepository = repository;
    }
    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream()
                .map(student -> new StudentDTO(student.getFirstName(), student.getLastName(), student.getJmbag(), student.getNumberOfECTS(), student.needsToPay()))
                .collect(Collectors.toList());
    }
    @Override
    public Optional<StudentDTO> findStudentByJMBAG(String JMBAG) {
        return studentRepository.findStudentByJMBAG(JMBAG).stream()
                .map(student -> new StudentDTO(student.getFirstName(), student.getLastName(), student.getJmbag(), student.getNumberOfECTS(), student.needsToPay()))
                .findAny();
    }
    @Override
    public Optional<StudentDTO> updateStudentByJmbag(Student student) {
        return studentRepository.updateStudentByJMBAG(student)
                .map(s ->
                        new StudentDTO(
                                s.getFirstName(),
                                s.getLastName(),
                                s.getJmbag(),
                                s.getNumberOfECTS(),
                                s.needsToPay()
                        ));
    }
    @Override
    public Optional<StudentDTO> save(Student student) {
        if(studentRepository.findStudentByJMBAG(student.getJmbag()).isPresent()){
            return Optional.ofNullable(null);
        }
        else {
            return studentRepository.save(student)
                    .map(s -> new StudentDTO(s.getFirstName(), s.getLastName(), s.getJmbag(), s.getNumberOfECTS(), s.needsToPay()));
        }
    }
    @Override
    public void deleteByJmbag(String JMBAG) {
        studentRepository.deleteByJMBAG(JMBAG);
    }
}
