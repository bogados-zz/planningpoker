package com.bogados.planning.rest.controller;

import com.bogados.planning.error.UserNotFoundException;
import com.bogados.planning.model.User;
import com.bogados.planning.rest.dto.GetAllUserResponse;
import com.bogados.planning.rest.dto.GetUserResponse;
import com.bogados.planning.service.UserService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {
	@Autowired
	private UserService userService;

	@Autowired
	private MapperFacade orikaMapper;

	@GetMapping
	public Page<GetAllUserResponse> getAllUsers(Pageable pageable) {
		Page<User> result = userService.findAll(pageable);
		return new PageImpl<>(orikaMapper.mapAsList(result.getContent(), GetAllUserResponse.class), result.getPageable(), result.getTotalElements() );
	}

	@GetMapping("/{id}")
	public GetUserResponse getUSerById(@PathVariable("id") Long id) {
		User result = userService.findById(id).orElseThrow(() -> new UserNotFoundException());
		return orikaMapper.map(result, GetUserResponse.class);
	}

}
