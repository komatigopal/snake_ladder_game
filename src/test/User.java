package test;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int id;
	private String name;
	private List<String> history;
	private int position;

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.position = 0;
		this.history = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getHistory() {
		return history;
	}

	public void setHistory(List<String> history) {
		this.history = history;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", history=" + history + ", position=" + position + "]";
	}

}
