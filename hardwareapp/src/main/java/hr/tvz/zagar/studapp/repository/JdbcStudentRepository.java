package hr.tvz.zagar.studapp.repository;

import hr.tvz.zagar.studapp.entity.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Primary
@Repository
public class JdbcStudentRepository implements StudentRepository{

    private static final String SELECT_ALL =
            "SELECT id, first_name, last_name, date_of_birth, jmbag, ects_points FROM student";
    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert inserter;

    public JdbcStudentRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
        this.inserter = new SimpleJdbcInsert(jdbc)
                .withTableName("student")
                .usingGeneratedKeyColumns("id");
    }
    @Override
    public List<Student> findAll() {
        return List.copyOf(jdbc.query(SELECT_ALL, this::mapRowToStudent));
    }

    @Override
    public Optional<Student> findStudentByJMBAG(String JMBAG) {
        try {
            return Optional.ofNullable(
                    jdbc.queryForObject(SELECT_ALL + " WHERE jmbag = ?", this::mapRowToStudent, JMBAG)
            );
        } catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<Student> save(Student student) {
        try {
            student.setId(saveStudentDetails(student));
            return Optional.of(student);
        } catch (DuplicateKeyException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Student> updateStudentByJMBAG(Student student) {
        System.out.println("\n student: " + student.getJmbag() + "\n");
        int executed = jdbc.update("UPDATE student set " +
                "first_name = ?, " +
                "last_name = ?, " +
                "date_of_birth = ?, " +
                "ects_points = ? " +
                "WHERE jmbag = ?",
                student.getFirstName(),
                student.getLastName(),
                student.getDateOfBirth(),
                student.getNumberOfECTS(),
                student.getJmbag()
        );
        System.out.println("prrrrrrrrr: " + executed + "\n");
        if (executed > 0){
            return Optional.of(student);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteByJMBAG(String JMBAG) {
        jdbc.update("DELETE FROM student WHERE jmbag = ?", JMBAG);
    }

    private Long saveStudentDetails(Student student){
        Map<String, Object> values = new HashMap<>();

        values.put("first_name", student.getFirstName());
        values.put("last_name", student.getLastName());
        values.put("date_of_birth", student.getDateOfBirth());
        values.put("jmbag", student.getJmbag());
        values.put("ects_points", student.getNumberOfECTS());
        return inserter.executeAndReturnKey(values).longValue();
    }

    private Student mapRowToStudent(ResultSet rs, int rowNum) throws SQLException {
        return new Student(
                rs.getLong("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getDate("date_of_birth").toLocalDate(),
                rs.getString("jmbag"),
                rs.getInt("ects_points")
        );
    }
}
