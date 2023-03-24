package Beans;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@NamedQuery(name="Commande.findAll", query="SELECT c FROM Commande c")
public class Commande implements Serializable {
	@Override
	public String toString() {
		return "Commande [id=" + id + ", client=" + client + ", product=" + product + "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "commande_id")
	private int id;
	
    @ManyToOne
    @JoinColumn(name = "client_id")
	private Client client;

    @ManyToOne
    @JoinColumn(name = "product_id")
	private Product product;

	public Commande() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
}