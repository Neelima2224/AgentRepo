package com.example.agent.controller;

import com.example.agent.model.Agent;
import com.example.agent.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/agents")
public class AgentController {
    @Autowired
    AgentService agentService;

    @PostMapping("/create")
    private Agent create(@RequestBody Agent agent) {
        return agentService.add(agent);
    }


    @GetMapping("/all")
    private List<Agent> getAll() {
        return agentService.getAllAgent();
    }


    @PutMapping("/{id}")
    private Agent update(@PathVariable("id") Long id, @RequestBody Agent agent) {
        agentService.update(agent, id);
        return agent;
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") Long id) {
        agentService.delete(id);
    }

    @GetMapping("/{id}")
    private Agent get(@PathVariable("id") Long id) throws Exception {
        return agentService.getAgentById(id);
    }
}
