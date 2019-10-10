package com.bogados.planning.security;

import com.bogados.planning.model.User;
import com.bogados.planning.repository.UserRepository;
import com.bogados.planning.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import static com.bogados.planning.security.SecurityConstants.HEADER_STRING;
import static com.bogados.planning.security.SecurityConstants.TOKEN_PREFIX;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private AuthenticationManager authenticationManager;
	private UserRepository userRepository;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
		setFilterProcessesUrl("/users/login");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req,
	                                            HttpServletResponse res) throws AuthenticationException {
		try {
			if (userRepository == null) {
				ServletContext servletContext = req.getServletContext();
				WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
				userRepository = webApplicationContext.getBean(UserRepository.class);
			}

			User user = new ObjectMapper()
					.readValue(req.getInputStream(), User.class);

			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							user.getUsername(),
							user.getPassword(),
							new ArrayList<>())
			);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req,
	                                        HttpServletResponse res,
	                                        FilterChain chain,
	                                        Authentication auth) throws IOException, ServletException {

		String token = JWTRepository.getInstance().create(((org.springframework.security.core.userdetails.User) auth.getPrincipal()).getUsername(), !((org.springframework.security.core.userdetails.User) auth.getPrincipal()).getAuthorities().isEmpty());

		JWTRepository.getInstance().addToken(token);

		Optional<User> user = userRepository
				.findUserByUsername(((org.springframework.security.core.userdetails.User) auth.getPrincipal()).getUsername());
		if (user.isPresent()) {
			user.get().setLastLogin(LocalDateTime.now());
			userRepository.save(user.get());
		}
		res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
	}
}
