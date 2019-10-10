package com.bogados.planning.repository;

import com.bogados.planning.model.User;

import java.util.Optional;

public interface UserRepository extends BaseBeanRepository<User>{
	Optional<User> findUserByUsername(String username);
}
