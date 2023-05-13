package hr.tvz.zagar.studapp.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(name = "ects_points")
    private Integer ects;
    @ManyToMany(targetEntity = Student.class, mappedBy = "courses")
    private Set<Student> students;
    public String getName() {
        return name;
    }
    public Integer getEcts() {
        return ects;
    }
}
