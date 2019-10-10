package com.bogados.planning.service;

import com.bogados.planning.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface UserService {
	Page<User> findAll(Pageable pageable);

	Optional<User> findById(Long id);

	Optional<User> findUserByUsername(String username);

	User updateUser(User user);
}
