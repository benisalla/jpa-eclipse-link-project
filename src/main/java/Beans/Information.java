package Beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the information database table.
 * 
 */
@Entity
@NamedQuery(name="Information.findAll", query="SELECT i FROM Information i")
public class Information implements Serializable {
	@Override
	public String toString() {
		return "Information [id=" + id + ", address=" + address + ", clientId=" + clientId + ", email=" + email
				+ ", client=" + client + "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String address;

	@Column(name="client_id")
	private String clientId;

	private String email;

	//bi-directional one-to-one association to Client
	@OneToOne(mappedBy = "information")
	private Client client;

	public Information() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}