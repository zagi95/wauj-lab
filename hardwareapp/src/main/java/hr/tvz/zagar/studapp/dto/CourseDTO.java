package hr.tvz.zagar.studapp.dto;

public class CourseDTO {
    private final String name;
    private  final Integer ects;
    public CourseDTO(String name, Integer ects){
        this.name = name;
        this.ects = ects;
    }

    public String getName() {
        return name;
    }

    public Integer getEcts() {
        return ects;
    }
}
