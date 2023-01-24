package com.example.agent.repo;

import com.example.agent.model.Agent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.naming.Name;
import javax.persistence.Id;
import java.util.List;
import java.util.Map;

@Repository
public interface AgentRepository extends CrudRepository<Agent, Long> {
  /*  @Query(value = "SELECT id,name  FROM agents")
    List<Map<String, Long>> getAll();*/
}
