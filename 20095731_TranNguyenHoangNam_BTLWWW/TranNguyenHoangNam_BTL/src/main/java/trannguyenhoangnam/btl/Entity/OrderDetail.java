package trannguyenhoangnam.btl.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import trannguyenhoangnam.btl.Entity.Order;



@Entity
@Table(name="order_items")
public class OrderDetail implements Serializable{
	private static final long serialVersionUID = 7793469511895300150L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;


	@ManyToOne
	@JoinColumn(name="product_id")
	private Product producid;
	
	
	@ManyToOne()
	@JoinColumn(name="order_id")
	private Order orderId;
	
	private int quantity;
	
	private double price;	
	
	public OrderDetail(Product producid, Order orderId, int quantity, double price) {
		super();
		this.producid = producid;
		this.orderId = orderId;
		this.quantity = quantity;
		this.price = price;
	}
	public OrderDetail(Product producId, Order orderId, int quantity) {
		super();
		this.producid = producId;
		this.orderId = orderId;
		this.quantity = quantity;
	}
	public OrderDetail() {
		super();
	}
	public Product getProducId() {
		return producid;
	}
	public void setProducId(Product producId) {
		this.producid = producId;
	}
	public Order getOrderId() {
		return orderId;
	}
	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "OrderDetail [producid=" + producid +  ", quantity=" + quantity + ", price="
				+ price + "]";
	}
	
	
	
	
	
	
	
}
