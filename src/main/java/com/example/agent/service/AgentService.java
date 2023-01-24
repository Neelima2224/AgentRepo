package com.example.agent.service;

import com.example.agent.model.Agent;
import com.example.agent.repo.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AgentService {
    @Autowired
    AgentRepository agentRepository;

    public Agent add(Agent agent) {
        return agentRepository.save(agent);
    }

    public List<Agent> getAllAgent() {
        List<Agent> agent = new ArrayList<Agent>();
        agentRepository.findAll().forEach(agent1 -> agent.add(agent1));
        System.out.println("getting data from db success");
        return agent;
    }

    public Agent getAgentById(Long id) throws Exception {

        return agentRepository.findById(id)
                .orElseThrow(() -> new Exception("Agent not found"));

    }


    public Agent update(Agent agent, Long id) {
        return agentRepository.save(agent);
    }

    public void delete(Long id) {
        try {
            Agent agent = agentRepository.findById(id)
                    .orElseThrow(() -> new Exception("Agent not found"));
            agentRepository.delete(agent);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
