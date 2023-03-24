package Beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	@Override
	public String toString() {
		return "Client [id=" + id + ", age=" + age + ", gender=" + gender + ", name=" + name + ", information="
				+ information + ", commandes=" + commandes + "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "client_id")
	private int id;

	private int age;

	private String gender;

	private String name;

	//bi-directional one-to-one association to Client
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID", referencedColumnName = "ID")
    private Information information;
	
	//one to many association to commande
	@OneToMany(mappedBy = "client")
	private List<Commande> commandes;

	public Client() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Information getInformation() {
		return this.information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}

}