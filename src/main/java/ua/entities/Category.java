package ua.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;
    private String brand;


    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Commodity> commodities;
//    @ManyToOne(fetch=FetchType.EAGER)
//    private Category parent;
//    @OneToMany(fetch=FetchType.EAGER)
//    private List<Category> childs = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public Category() {
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public List<Commodity> getCommodities() {
		return commodities;
	}

	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}

}
