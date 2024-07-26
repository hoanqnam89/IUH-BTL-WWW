package trannguyenhoangnam.btl.Entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Table(name = "products")
@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int idProduct;

	@Column(columnDefinition = "nvarchar(50)")
	@Pattern(regexp = "[A-Z][a-zA-Z0-9 ]+",message = "Tên sản phẩm không rỗng, không chứa kí tự đặt biệt, bắt đầu kí tự hoa")
	private String nameProduct;

	@ManyToOne
	@JoinColumn(name = "cate_id")
	public Categories categories;

	@Column(columnDefinition = "nvarchar(255)")
	@NotNull(message = "mô tả sản phẩm không rỗng")
	private String motasp;

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "list_images", joinColumns = @JoinColumn(name = "product_id"), uniqueConstraints = @UniqueConstraint(columnNames = {
			"product_id", "imgpath" }))
	@Column(name = "imgpath")
	public List<String> listImage;
	@NotNull(message = "Không rỗng")
	private double price;

	private boolean inStock;

	private String size;
	private int soluong;
	@OneToMany(mappedBy = "producid",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	public Set<OrderDetail> orderDetails;
	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}	
	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public String getMotasp() {
		return motasp;
	}

	public void setMotasp(String motasp) {
		this.motasp = motasp;
	}

	public List<String> getListImage() {
		return listImage;
	}

	public void setListImage(List<String> listImage) {
		this.listImage = listImage;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", nameProduct=" + nameProduct + ", categories=" + categories
				+ ", motasp=" + motasp + ", listImage=" + listImage + ", price=" + price + ", inStock=" + inStock
				+ ", size=" + size + ", soluong=" + soluong + "]";
	}

	public Product(int idProduct,
			@NotNull(message = "Không rỗng") @Pattern(regexp = "[A-Za-z0-9]", message = "name Product không chưa kí tự đặt biệt") String nameProduct,
			Categories categories, String motasp, List<String> listImage,
			@NotNull(message = "Không rỗng") @Pattern(regexp = "[0-9]{5}[0-9]$", message = "price chỉ được nhập số và ít nhất 5 chữ số") Double price,
			boolean inStock, String size, int soluong) {
		super();
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.categories = categories;
		this.motasp = motasp;
		this.listImage = listImage;
		this.price = price;
		this.inStock = inStock;
		this.size = size;
		this.soluong = soluong;
	}

	public Product(
			@NotNull(message = "Không rỗng") @Pattern(regexp = "[A-Za-z0-9]", message = "name Product không chưa kí tự đặt biệt") String nameProduct,
			Categories categories, String motasp, List<String> listImage, @NotNull(message = "Không rỗng") double price,
			boolean inStock, String size, int soluong) {
		super();
		this.nameProduct = nameProduct;
		this.categories = categories;
		this.motasp = motasp;
		this.listImage = listImage;
		this.price = price;
		this.inStock = inStock;
		this.size = size;
		this.soluong = soluong;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
