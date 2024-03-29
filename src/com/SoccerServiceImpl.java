package com;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoccerServiceImpl implements SoccerService {

	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	public List<String> getAllTeamPlayers(long teamId) {
		
		List<String> result = new ArrayList<>();
		List<Player> players = playerRepository.findByTeamId(teamId);
		
		for(Player player : players) {
			result.add(player.getName());
		}
		return result;
	}

	public void addBarcelonaPlayer(String name, String position, int number) {
		
		Team barcelona = teamRepository.findByPlayers((long) number);
        Player newPlayer = new Player();
        newPlayer.setName(name);
        newPlayer.setPosition(position);
        newPlayer.setTeam(barcelona);
        playerRepository.save(newPlayer);
	}
}
