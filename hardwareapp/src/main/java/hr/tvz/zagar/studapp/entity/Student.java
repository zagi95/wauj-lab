package hr.tvz.zagar.studapp.entity;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String jmbag;
    @Column(name = "ects_points")
    private Integer numberOfECTS;
    @ManyToMany(targetEntity = Course.class)
    @JoinTable(
            name = "student_course",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    private List<Course> courses;

    public Student(Long id, String firstName, String lastName, LocalDate dateOfBirth, String jmbag, Integer numberOfECTS) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.jmbag = jmbag;
        this.numberOfECTS = numberOfECTS;
    }

    public Student() {

    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public String getJmbag() {
        return jmbag;
    }
    public Integer getNumberOfECTS() {
        return numberOfECTS;
    }
    public boolean needsToPay(){
        return dateOfBirth.isAfter(LocalDate.now().minusYears(26));
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setNumberOfECTS(Integer ects) {
        this.numberOfECTS = ects;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
