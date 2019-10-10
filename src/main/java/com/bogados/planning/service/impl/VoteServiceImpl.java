package com.bogados.planning.service.impl;

import com.bogados.planning.repository.VoteRepository;
import com.bogados.planning.service.VoteService;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {

	private final VoteRepository voteRepository;

	public VoteServiceImpl(VoteRepository voteRepository) {
		this.voteRepository = voteRepository;
	}
}
