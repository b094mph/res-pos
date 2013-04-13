package com.res.dao.hibernate;

import java.util.List;

import com.res.model.Agent;

public interface AgentDao extends BaseDao{

	public Agent getAgentById(long id);
	public Agent getAgentByUsername(String username);
	public List<String> getAgentUsernames();
}
