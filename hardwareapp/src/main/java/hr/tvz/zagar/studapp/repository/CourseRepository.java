package hr.tvz.zagar.studapp.repository;

import hr.tvz.zagar.studapp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByStudents_Jmbag(String jmbag);
}
