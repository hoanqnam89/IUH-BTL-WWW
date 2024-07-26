package trannguyenhoangnam.btl.Entity;

import java.io.Serializable;

public class ThongKe implements Serializable{
	private static final long serialVersionUID = 1L;
	public Product product;
	public int quantity;
	public double price;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ThongKe [product=" + product + ", quantity=" + quantity + ", price=" + price + "]";
	}
	public ThongKe(Product product, int quantity, double price) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}
	
	
}
