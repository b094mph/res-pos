package com.res.service;

import com.res.model.Agent;

public interface AgentService {

	public Boolean verifyAgent(Agent agent);
	public Boolean isNewAgent(String username);
	public Boolean isPasswordValid(String username, String password);
}
