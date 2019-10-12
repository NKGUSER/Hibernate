package com;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface SoccerService {

	public List<String> getAllTeamPlayers(long teamId);
    public void addBarcelonaPlayer(String name, String position, int number);
}
