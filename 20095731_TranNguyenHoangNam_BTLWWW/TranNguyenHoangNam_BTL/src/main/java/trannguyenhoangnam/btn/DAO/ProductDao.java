package trannguyenhoangnam.btn.DAO;

import java.util.List;

import trannguyenhoangnam.btl.Entity.Product;
import trannguyenhoangnam.btl.Entity.ThongKe;

public interface ProductDao {
	public Product getProductById(int id);
	public boolean save(Product product);
	public boolean update(Product product);
	public boolean delete(Product product);
	public List<Product> getAllProduct(int page); 
	public List<Product> getNewProduct(int page); 
	public List<Product> getSaleProduct(int page); 
	public List<Product> getProductTheoNhieuTieuChi(String tieuchi); 
	public List<ThongKe> getTop10DuocBanNhieuNhat(); 
}
