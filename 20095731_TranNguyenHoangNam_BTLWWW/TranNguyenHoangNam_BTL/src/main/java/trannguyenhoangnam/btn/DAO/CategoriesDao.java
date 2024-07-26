package trannguyenhoangnam.btn.DAO;

import java.util.List;

import trannguyenhoangnam.btl.Entity.Categories;

public interface CategoriesDao {
	public Categories getOne(int id);
	public boolean save(Categories category);
	public boolean update(Categories category);
	public boolean delete(Categories category);
	public List<Categories> getAllCategories();
}
