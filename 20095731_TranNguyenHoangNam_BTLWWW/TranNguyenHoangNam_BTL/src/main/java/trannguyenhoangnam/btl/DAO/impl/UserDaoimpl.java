package trannguyenhoangnam.btl.DAO.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import trannguyenhoangnam.btl.Entity.User;
import trannguyenhoangnam.btn.DAO.UserDao;


@Repository
public class UserDaoimpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<User> getAllUser() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> theQuery = currentSession.createQuery("from User ", User.class);
		List<User> customers = theQuery.getResultList();
		return customers;
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();

		// Kiểm tra xem tên người dùng đã tồn tại hay chưa
		Query<User> query = currentSession.createQuery("from User where username = :username", User.class);
		query.setParameter("username", user.getUsername());

		User existingUser = query.uniqueResult();

		if (existingUser != null) {
			// Nếu tên người dùng đã tồn tại, có thể thông báo lỗi hoặc xử lý tùy thuộc vào
			// yêu cầu của bạn
			// Ví dụ: Ném ra một ngoại lệ hoặc thông báo lỗi
			throw new RuntimeException("Tên người dùng đã tồn tại. Vui lòng chọn tên người dùng khác.");
		} else {
			// Nếu tên người dùng chưa tồn tại, thêm người dùng vào cơ sở dữ liệu
			currentSession.saveOrUpdate(user);
		}
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(user);
	}

	@Override
	@Transactional
	public User findUserById(int id) {
	    Session currentSession = sessionFactory.getCurrentSession();
	    User user = currentSession.get(User.class, id);
	    return user;
	}
	@Override
	@Transactional
	public int getUserIdByUsernameAndPassword(String username, String password) {
	    Session currentSession = sessionFactory.getCurrentSession();
	    Query<Integer> query = currentSession.createQuery("select id from User where username = :username and password = :password", Integer.class);
	    query.setParameter("username", username);
	    query.setParameter("password", password);
	    Integer userId = query.uniqueResult();
	    return userId != null ? userId : -1; // Trả về -1 nếu không tìm thấy user
	}
	@Override
	@Transactional
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from User where id=:id");
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();
	}



	@Override
	@Transactional
	public User getUser(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		// now retrieve/read from database using the primary key
		User user = currentSession.get(User.class, id);
		return user;
	}
	@Override
	@Transactional
	public boolean isUserAdmin(String username, String password) {
	    try (Session session = sessionFactory.openSession()) {
	        // Kiểm tra xem có người dùng nào có vai trò là admin hay không
	        User user = (User) session
	                .createQuery("FROM User WHERE username = :username AND password = :password AND role = 'admin'")
	                .setParameter("username", username)
	                .setParameter("password", password)
	                .uniqueResult();
	        
	        return user != null;
	    } catch (Exception e) {
	        // Log lỗi thay vì in stack trace và trả về false
	        return false;
	    }
	}
	
	@Override
	@Transactional
	public boolean isLogin(String username, String password) {
	    try (Session session = sessionFactory.openSession()) {
	        // Kiểm tra xem có người dùng nào có tài khoản không
	        User user = (User) session
	                .createQuery("FROM User WHERE username = :username AND password = :password")
	                .setParameter("username", username)
	                .setParameter("password", password)
	                .uniqueResult();

	        return user != null;
	    } catch (Exception e) {
	        // Log lỗi thay vì in stack trace và trả về false
	       
	        return false;
	    }
	}

	
	
}
