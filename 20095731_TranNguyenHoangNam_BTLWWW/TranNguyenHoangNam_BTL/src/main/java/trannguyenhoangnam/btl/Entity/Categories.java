package trannguyenhoangnam.btl.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "categories")
public class Categories implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idCate;
	
	@Column(name = "name")
	@Pattern(regexp = "[A-Za-z][A-Za-z ]*",message = "Tên danh mục không rỗng, không chứa số, kí tự đặt biệt")
	public String namecategories;
	
	@OneToMany(mappedBy = "categories",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	public Set<Product> product;

	public int getIdCate() {
		return idCate;
	}

	public void setIdCate(int idCate) {
		this.idCate = idCate;
	}

	public String getNamecategories() {
		return namecategories;
	}

	public void setNamecategories(String namecategories) {
		this.namecategories = namecategories;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

	public Categories(int idCate, String namecategories, Set<Product> product) {
		super();
		this.idCate = idCate;
		this.namecategories = namecategories;
		this.product = product;
	}

	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Categories [idCate=" + idCate + ", namecategories=" + namecategories + ", product=" + product + "]";
	}

	public Categories(int idCate) {
		super();
		this.idCate = idCate;
	}
	
	
}
