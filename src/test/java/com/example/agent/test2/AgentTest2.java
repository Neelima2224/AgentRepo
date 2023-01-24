package com.example.agent.test2;

import com.example.agent.model.Agent;
import com.example.agent.repo.AgentRepository;
import com.example.agent.service.AgentService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AgentTest2 {
    @InjectMocks
    private AgentService agentService;
    @Mock
    private AgentRepository agentRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllAgentTest() {
        Mockito.when(agentRepository.findAll()).thenReturn(Stream.of(new Agent(1280L, "Neelima", "Hyderbad", 95678998L, "India", 500049L)).collect(Collectors.toList()));
        assertEquals(1, agentService.getAllAgent().size());
    }

    @Test
    public void addTest() {
        Agent agent = (new Agent(1240L, "Gavara", "Bangalore", 887948098L, "India", 500050L));
        Mockito.when(agentRepository.save(agent)).thenReturn(agent);
        assertEquals(agent, agentService.add(agent));
    }

    @Test
    public void getAgentByIdTest() throws Exception {
        Long id = 1240l;
        Agent agent = (new Agent(1240l, "Gavara", "Banglore", 8879482098L, "India", 500050L));
        Mockito.when(agentRepository.findById(id)).thenReturn(Optional.of(agent));
        assertEquals(1240, agentService.getAgentById(id));
    }

    @Test
    public void updateTest() {
        Agent agent = new Agent(1280L, "NeelimaGavara", "Hyderabad", 9390956909L, "India", 500049L);
        Mockito.when(agentRepository.save(agent)).thenReturn(agent);
        assertEquals(agent,agentService.update(agent,agent.getId()));
    }
    @Test
    public void   deleteTest(){
        Agent agent = new Agent(1280L,"Gavara","Bangalore",8879482098L,"India",500050L) ;
        agentService.delete(agent.getId());
        Mockito.verify(agentRepository,times(1)).deleteById(agent.getId()) ;
    }
}
