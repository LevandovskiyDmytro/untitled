package ua.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "discount", fetch = FetchType.LAZY)
    private List<Commodity> commodity;
    public Discount(){}
    public Discount(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Commodity> getGoods() {
        return commodity;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setGoods(List<Commodity> commodity) {
        this.commodity = commodity;
    }

    @Override
    public String toString() {
        return "Tag [id=" + id + ", name=" + name + ", commodity=" + commodity + "]";
    }
}
