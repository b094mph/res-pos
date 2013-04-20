package com.res.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.res.dao.hibernate.AgentDao;
import com.res.model.Agent;
import com.res.service.AgentService;

@Service("agentService")
@Transactional
public class AgentServiceImpl implements AgentService {

	private static Logger logger = Logger.getLogger(AgentServiceImpl.class);
	
	@Autowired
	public AgentDao agentDao;
	
	@Override
	public Boolean verifyAgent(Agent agent) {
		String username = agent.getUserName();
		boolean agentExist = isNewAgent(username);
		if(agentExist){
			String password = agent.getAgentPassword();
			return isPasswordValid(username, password);
		}
		agentDao.save(agent);
		return true;
	}

	@Override
	public Boolean isNewAgent(String username) {
		boolean agentExist = false;
		List<String> agentUsernameList =  agentDao.getAgentUsernames();
		for(String agentUsername : agentUsernameList){
			if(agentUsername.equalsIgnoreCase(username)){
				logger.debug(username + "is a new Agent.");
				agentExist = true;
			}
		}
		return agentExist;
	}

	@Override
	public Boolean isPasswordValid(String username, String password) {
		Boolean passwordValid = false;
		Agent agent = agentDao.getAgentByUsername(username);
		if(agent.getAgentPassword().equals(password)){
			logger.debug("Agent " + username + "authenticated.");
			passwordValid = true;
		}
		return passwordValid;
	}

}
