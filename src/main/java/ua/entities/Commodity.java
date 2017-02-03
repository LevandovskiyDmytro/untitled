package ua.entities;

import java.util.List;

import javax.persistence.*;


@Entity
public class Commodity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;
    private String brand;
    private String model;
    private int price;
    private String pathToImage;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_commodity",
            joinColumns = @JoinColumn(name = "id_commodity"),
            inverseJoinColumns = @JoinColumn(name = "id_user"))
    private List<User> users;


    @ManyToOne
    private Category category;
    
    @ManyToOne
    private Discount discount;


    public Commodity() {
    }

    public Commodity(String type, String brand, String model, int price) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.price = price;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
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

    public String getPathToImage() {
        return pathToImage;
    }

    public void setPathToImage(String pathToImage) {
        this.pathToImage = pathToImage;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", discount=" + discount +
                '}';
    }
}
