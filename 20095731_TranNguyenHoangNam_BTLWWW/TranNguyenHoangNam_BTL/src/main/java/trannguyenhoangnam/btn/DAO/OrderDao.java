package trannguyenhoangnam.btn.DAO;

import java.util.List;

import trannguyenhoangnam.btl.Entity.Order;
import trannguyenhoangnam.btl.Entity.OrderDetail;

public interface OrderDao {
	public void addOrder(Order order);
	public void updateOrder(Order order);
	public List<Order> getAllOrderByUserID(int userID);
	public List<Order> getAllOrder();
	public Order getOrderByID(int orderID);
	public List<OrderDetail> getOrderDetailByOrderID(int orderID);
	//public boolean deleteOrder(int orderID);
	public boolean editOrder(Order order);
	
}
