package hr.tvz.zagar.studapp.dto;

public class StudentDTO {
    private final String jmbag;
    private final Integer ects;
    private final boolean needsToPay;

    public StudentDTO(String jmbag, Integer ects, boolean needsToPay) {
        this.jmbag = jmbag;
        this.ects = ects;
        this.needsToPay = needsToPay;
    }

    public String getJmbag() {
        return jmbag;
    }
    public Integer getEcts() {
        return ects;
    }
    public boolean isNeedsToPay() {
        return needsToPay;
    }
    @Override
    public String toString() {
        return "StudentDTO{" +
                "JMBAG='" + jmbag + '\'' +
                ", numberOfECTS=" + ects +
                ", tuitionShouldBePaid=" + needsToPay +
                '}';
    }
}
