package ua.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Delivery {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;

	public Delivery(String name) {
		this.name = name;
	}

	public Delivery() {

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

	@Override
	public String toString() {
		return "Delivery [id=" + id + ", name=" + name + "]";
	}


}
