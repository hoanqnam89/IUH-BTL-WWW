package trannguyenhoangnam.btl.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import trannguyenhoangnam.btl.Entity.Categories;
import trannguyenhoangnam.btl.Entity.Product;
import trannguyenhoangnam.btl.Entity.ThongKe;
import trannguyenhoangnam.btn.DAO.ProductDao;

@Repository
public class ProductDaoimpl implements ProductDao {

    @Autowired
    private SessionFactory factory;

    @Override
    @Transactional
    public boolean save(Product product) {
        try {
            factory.getCurrentSession().saveOrUpdate(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    @Transactional
    public List<Product> getAllProduct(int page) {
        List<Product> list = new ArrayList<>();
        int pageSize = 6;

        String queryStr = "SELECT * FROM products ORDER BY inStock DESC OFFSET :page ROWS FETCH NEXT :pageSize ROWS ONLY";
        NativeQuery<Object[]> query = factory.getCurrentSession().createNativeQuery(queryStr);
        query.setParameter("page", page);
        query.setParameter("pageSize", pageSize);

        list = getProducts(query);

        return list;
    }

    @Override
    @Transactional
    public boolean update(Product product) {
        try {
            factory.getCurrentSession().update(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    @Transactional
    public boolean delete(Product product) {
        try {
            factory.getCurrentSession().delete(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    @Transactional
    public Product getProductById(int id) {
        Product p = null;
        String queryStr = "SELECT * FROM products WHERE product_id = :id";
        NativeQuery<Object[]> query = factory.getCurrentSession().createNativeQuery(queryStr);
        query.setParameter("id", id);

        List<Product> list = getProducts(query);
        if (!list.isEmpty()) {
            p = list.get(0);
        }
        return p;
    }

    @Override
    @Transactional
    public List<Product> getNewProduct(int page) {
        return getAllProduct(page); // Sử dụng lại getAllProduct để tránh trùng lặp mã nguồn
    }

    @Override
    @Transactional
    public List<Product> getSaleProduct(int page) {
        List<Product> list = new ArrayList<>();
        int pageSize = 6;

        String queryStr = "SELECT * FROM products ORDER BY price OFFSET :page ROWS FETCH NEXT :pageSize ROWS ONLY";
        NativeQuery<Object[]> query = factory.getCurrentSession().createNativeQuery(queryStr);
        query.setParameter("page", page);
        query.setParameter("pageSize", pageSize);

        list = getProducts(query);

        return list;
    }

    @Override
    @Transactional
    public List<Product> getProductTheoNhieuTieuChi(String tieuchi) {
        List<Product> list = new ArrayList<>();

        String queryStr = "SELECT * FROM products WHERE product_id LIKE :tieuchi OR motasp LIKE :tieuchi OR nameProduct LIKE :tieuchi OR price LIKE :tieuchi OR size LIKE :tieuchi";
        NativeQuery<Object[]> query = factory.getCurrentSession().createNativeQuery(queryStr);
        query.setParameter("tieuchi", "%" + tieuchi + "%");

        list = getProducts(query);

        return list;
    }

    @Override
    @Transactional
    public List<ThongKe> getTop10DuocBanNhieuNhat() {
        List<ThongKe> list = new ArrayList<>();

        String queryStr = "SELECT top 10 products.product_id, order_items.quantity, order_items.price FROM products INNER JOIN order_items on products.product_id = order_items.product_id GROUP by products.product_id, order_items.quantity, order_items.price ORDER BY quantity DESC";
        NativeQuery<Object[]> query = factory.getCurrentSession().createNativeQuery(queryStr);

        for (Object[] o : query.getResultList()) {
            list.add(new ThongKe(getProductById((int) o[0]), (int) o[1], (double) o[2]));
        }
        return list;
    }

    private List<Product> getProducts(NativeQuery<Object[]> query) {
        List<Product> list = new ArrayList<>();

        for (Object[] o : query.getResultList()) {
            List<String> listimg = new ArrayList<>();
            String imgQueryStr = "SELECT * FROM list_images WHERE product_id = :productId";
            NativeQuery<Object[]> imgQuery = factory.getCurrentSession().createNativeQuery(imgQueryStr);
            imgQuery.setParameter("productId", o[0]);

            for (Object[] o1 : imgQuery.getResultList()) {
                listimg.add((String) o1[1]);
            }
            list.add(new Product((int) o[0], (String) o[3], new Categories((int) o[7]), (String) o[2], listimg,
                    (double) o[4], (boolean) o[1], (String) o[5], (int) o[6]));
        }
        return list;
    }
}
