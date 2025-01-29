package test;

import java.util.ArrayList;
import java.util.List;

public class GetLaddersSnackesUsers {
	private List<Snake> snakes;
	private List<Ladder> ladders;
	private List<User> users;

	private static GetLaddersSnackesUsers instance = null;

	private GetLaddersSnackesUsers() {
		snakes = new ArrayList<>();
		ladders = new ArrayList<>();
		users = new ArrayList<>();
	}

	public List<Snake> getSnakes() {
		return snakes;
	}

	public void setSnakes(List<Snake> snakes) {
		this.snakes = snakes;
	}

	public List<Ladder> getLadders() {
		return ladders;
	}

	public void setLadders(List<Ladder> ladders) {
		this.ladders = ladders;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public static GetLaddersSnackesUsers getInstance() {
		if (instance == null) {
			instance = new GetLaddersSnackesUsers();
		}
		return instance;
	}

	@Override
	public String toString() {
		return "GetLaddersSnackesUsers [snakes=" + snakes + ", ladders=" + ladders + ", users=" + users + "]";
	}

}