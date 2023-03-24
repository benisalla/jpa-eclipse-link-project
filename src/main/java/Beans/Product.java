package Beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double amount;
	private double price;
	private String type;
	
	//one to many association to commande
	@OneToMany(mappedBy = "product")
	private List<Commande> commandes;

	public Product(int id, double amount, double price, String type) {
		super();
		this.id = id;
		this.amount = amount;
		this.price = price;
		this.type = type;
	}
	
	public Product() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", amount=" + amount + ", price=" + price + ", type=" + type + ", commandes="
				+ commandes + "]";
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
}