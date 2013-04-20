package com.res.dao.hibernate.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.res.dao.hibernate.AgentDao;
import com.res.model.Agent;

@Repository("agentDao")
public class AgentDaoImpl extends BaseDaoImpl implements AgentDao {
	
	private static Logger logger = Logger.getLogger(AgentDaoImpl.class);

	@Override
	public Agent getAgentById(long id) {
		return (Agent) currentSession().get(getClass(), id);
	}

	@Override
	public Agent getAgentByUsername(String username) {
		StringBuffer sb = new StringBuffer();
		sb.append("FROM Agent a WHERE a.userName = :username");
		Query query = currentSession().createQuery(sb.toString());
		query.setString("username", username);
		return (Agent) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAgentUsernames() {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT a.userName FROM Agent a");
		Query query = currentSession().createQuery(sb.toString());
		return (List<String>) query.list();
	}

}
