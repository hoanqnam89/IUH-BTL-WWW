package trannguyenhoangnam.btl.Entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="orders")
public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1469356589518599584L;
	@Id
	@Column(name="order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="order_date")
	private LocalDate orderDate;

	@ManyToOne
	@JoinColumn(name = "user_id")
	public User user;
	
	
	@OneToMany(mappedBy = "orderId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	public Set<OrderDetail> ordetail;
	

	public Order(int id, LocalDate orderDate) {
		super();
		this.id = id;
		this.orderDate = orderDate;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<OrderDetail> getOrdetail() {
		return ordetail;
	}
	public void setOrdetail(Set<OrderDetail> ordetail) {
		this.ordetail = ordetail;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", user=" + user + ", ordetail=" + ordetail.toString() + "]";
	}
	public Order( LocalDate orderDate, User user, Set<OrderDetail> ordetail) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.user = user;
		this.ordetail = ordetail;
	}
	
}
