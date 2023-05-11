package hr.tvz.zagar.studapp.service;

import hr.tvz.zagar.studapp.dto.CourseDTO;
import hr.tvz.zagar.studapp.dto.UserDTO;
import hr.tvz.zagar.studapp.entity.Course;
import hr.tvz.zagar.studapp.entity.User;
import hr.tvz.zagar.studapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserDTO> findByUsername(String username){
        return userRepository.findByUsername(username).stream()
                .map(this::matUserToDTO)
                .findAny();
    }

    private UserDTO matUserToDTO(User user){
        return new UserDTO(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName(), user.getAuthoritiesToString());
    }
}
