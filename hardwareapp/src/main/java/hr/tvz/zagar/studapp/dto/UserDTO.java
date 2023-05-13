package hr.tvz.zagar.studapp.dto;

import java.util.Set;

public class UserDTO {
    private Long id;
    private final String username;
    private  final String firstName;
    private final String lastName;
    private final Set<String> authorities;

    public UserDTO(Long id, String username, String firstName, String lastName, Set<String> authorities) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.authorities = authorities;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }
}
