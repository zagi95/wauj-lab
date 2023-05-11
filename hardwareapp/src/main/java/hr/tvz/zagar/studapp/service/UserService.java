package hr.tvz.zagar.studapp.service;

import hr.tvz.zagar.studapp.dto.UserDTO;

import java.util.Optional;

public interface UserService {
    Optional<UserDTO> findByUsername(String username);
}
