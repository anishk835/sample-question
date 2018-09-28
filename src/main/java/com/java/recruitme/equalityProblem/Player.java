package com.java.recruitme.equalityProblem;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;

public class Player  {

	private String name;
	private int jerseyNumber;

	public Player(String name, int jerseyNumber) {
		this.name = name;
		this.jerseyNumber = jerseyNumber;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (jerseyNumber != other.jerseyNumber)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + jerseyNumber;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	public static void main(String[] args) {
		Set<Player> players = new HashSet<Player>();
	      players.add(new Player("Sachin",10));
	      players.add(new Player("Sachin",10));
	      System.out.println(players.size());
	}
	

}
