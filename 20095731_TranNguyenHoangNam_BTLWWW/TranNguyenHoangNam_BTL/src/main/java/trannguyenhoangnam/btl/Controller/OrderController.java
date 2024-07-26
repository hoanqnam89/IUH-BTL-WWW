package trannguyenhoangnam.btl.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import trannguyenhoangnam.btl.Entity.Order;
import trannguyenhoangnam.btl.Entity.OrderDetail;
import trannguyenhoangnam.btl.Entity.Product;
import trannguyenhoangnam.btn.DAO.OrderDao;
import trannguyenhoangnam.btn.DAO.ProductDao;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @RequestMapping("/orderController")
    public String listOrders(Model model, HttpSession session) {
        // Lấy danh sách đơn hàng từ cơ sở dữ liệu
        List<Order> orders = orderDao.getAllOrder();

        model.addAttribute("orders", orders);
        return "list_order";
    }

    @RequestMapping("/view")
    public String viewOrder(@RequestParam("id") int orderId, Model model) {
        // Lấy thông tin đơn hàng từ cơ sở dữ liệu
        Order order = orderDao.getOrderByID(orderId);

        model.addAttribute("order", order);
        return "view_order";
    }
    @RequestMapping("/getByUserID")
    public String getOrdersByUserId(@RequestParam("getOrder") int userId,Model model) {
        // Lấy danh sách đơn hàng từ cơ sở dữ liệu dựa trên ID của người dùng
        List<Order> orders = orderDao.getAllOrderByUserID(userId);

        model.addAttribute("orders", orders);
        return "list_order"; // Thay đổi tên trang JSP tương ứng
    }
    
    @RequestMapping("/getByID")
    public String getOrdersById(/*@RequestParam("id") int orderId,*/ Model model) {
        // Lấy danh sách đơn hàng từ cơ sở dữ liệu dựa trên ID của đơn hàng
        Order order = orderDao.getOrderByID(1);
        System.out.println(order.getOrdetail());
        model.addAttribute("order", order);
        return "view_order";
    }
    @RequestMapping("/getByOrderID")
    public String getOrderDetailDByOrderId(@RequestParam("id") int orderId, Model model) {
        // Lấy danh sách đơn hàng từ cơ sở dữ liệu dựa trên ID của đơn hàng
    	 List<OrderDetail> order = orderDao.getOrderDetailByOrderID(orderId);

    
      model.addAttribute("order", order);
      System.out.println(order.get(0).getProducId().getListImage());
        return "list-orderDetail";
    }
    
    @RequestMapping("/addOrder")
    private String addOrder() {
		return null;
    	
    }
}
