package trannguyenhoangnam.btl.DAO.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import trannguyenhoangnam.btl.Entity.Categories;
import trannguyenhoangnam.btn.DAO.CategoriesDao;


@Repository
public class CategoriesDaoimpl implements CategoriesDao
{
	@Autowired
	public SessionFactory factory;
	
	@Override
	@Transactional
	public Categories getOne(int id) {
		Session currentSession = factory.getCurrentSession();
		Categories theCategories = currentSession.get(Categories.class, id);
		return theCategories;
	}

	@Override
	@Transactional
	public boolean save(Categories category) {
		factory.getCurrentSession().saveOrUpdate(category);
		return true;
	}

	@Override
	@Transactional
	public boolean update(Categories category) {
		factory.getCurrentSession().update(category);
		return true;
	}

	@Override
	@Transactional
	public List<Categories> getAllCategories() {
		Session currentSession = factory.getCurrentSession();
		Query<Categories> theQuery = currentSession.createQuery("from Categories order by name", Categories.class);
		List<Categories> categories = theQuery.getResultList();
		return categories;
	}

	@Override
	public boolean delete(Categories category) {
		// TODO Auto-generated method stub
		return false;
	}

}
