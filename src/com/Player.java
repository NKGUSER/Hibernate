package com;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Fetch;

@Entity
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_sequence")
	@SequenceGenerator(name = "player_sequence", sequenceName = "Player_SEQ")
	private Long id;
	
	@Column(name = "Fname")
	private String name;
	
	@Column
	private String position;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id" , nullable = false)
	private Team team;
	
	
	public Player() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	
}
