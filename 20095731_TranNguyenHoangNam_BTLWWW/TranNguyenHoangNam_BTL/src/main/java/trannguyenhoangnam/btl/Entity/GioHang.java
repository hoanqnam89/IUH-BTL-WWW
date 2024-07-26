package trannguyenhoangnam.btl.Entity;

import java.io.Serializable;

public class GioHang implements Serializable{
	public Product product;
	public int soluong;
	public double tonggia;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public double getTonggia() {
		return product.getPrice()*soluong;
	}
	public void setTonggia(double tonggia) {
		this.tonggia = tonggia;
	}
	@Override
	public String toString() {
		return "GioHang [product=" + product + ", soluong=" + soluong + ", tonggia=" + tonggia + "]";
	}
	public GioHang(Product product, int soluong, double tonggia) {
		super();
		this.product = product;
		this.soluong = soluong;
		this.tonggia = product.getPrice()*soluong;
	}
	public GioHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
