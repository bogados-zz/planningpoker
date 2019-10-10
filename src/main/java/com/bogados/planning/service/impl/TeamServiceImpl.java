package com.bogados.planning.service.impl;

import com.bogados.planning.repository.TeamRepository;
import com.bogados.planning.service.TeamService;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

	private final TeamRepository teamRepository;

	public TeamServiceImpl(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}
}
