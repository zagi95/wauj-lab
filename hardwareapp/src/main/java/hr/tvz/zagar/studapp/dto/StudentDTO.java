package hr.tvz.zagar.studapp.dto;

public class StudentDTO {

    private final String firstName;
    private final String lastName;
    private final String jmbag;
    private final Integer numberOfECTS;
    private final boolean tuitionShouldBePayed;

    public StudentDTO(String firstName, String lastName, String jmbag, Integer numberOfECTS, boolean tuitionShouldBePayed) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jmbag = jmbag;
        this.numberOfECTS = numberOfECTS;
        this.tuitionShouldBePayed = tuitionShouldBePayed;
    }

    public String getJmbag() {
        return jmbag;
    }
    public Integer getNumberOfECTS() {
        return numberOfECTS;
    }
    public boolean isTuitionShouldBePayed() {
        return tuitionShouldBePayed;
    }
    @Override
    public String toString() {
        return "StudentDTO{" +
                "JMBAG='" + jmbag + '\'' +
                ", numberOfECTS=" + numberOfECTS +
                ", tuitionShouldBePaid=" + tuitionShouldBePayed +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
