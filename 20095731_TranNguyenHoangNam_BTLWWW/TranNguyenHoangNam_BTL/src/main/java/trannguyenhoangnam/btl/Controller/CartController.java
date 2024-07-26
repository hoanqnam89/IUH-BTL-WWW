package trannguyenhoangnam.btl.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import trannguyenhoangnam.btl.Entity.Order;
import trannguyenhoangnam.btl.Entity.OrderDetail;
import trannguyenhoangnam.btl.Entity.Product;
import trannguyenhoangnam.btl.Entity.User;
import trannguyenhoangnam.btn.DAO.OrderDao;
import trannguyenhoangnam.btn.DAO.ProductDao;
import trannguyenhoangnam.btn.DAO.UserDao;

@Controller
public class CartController {

	@Autowired
	ProductDao prodao;
	@Autowired
	OrderDao orderdao;
	@Autowired
	UserDao userdao;
	@Autowired
	private JavaMailSender mailSender;
	@RequestMapping("/cart")
	public String GioHang(Model model, HttpSession session) {
		HashMap<Integer, Integer> list = (HashMap<Integer, Integer>) session.getAttribute("listOrderDetail");
		List<trannguyenhoangnam.btl.Entity.GioHang> gioHnag = new ArrayList<>();
		if (list == null ) {
			  
			return "redirect:/home";
		}

		list.entrySet().forEach(x -> {
			Product p = prodao.getProductById(x.getKey());
			gioHnag.add(new trannguyenhoangnam.btl.Entity.GioHang(p, x.getValue(), 0));
		});
		session.setAttribute("cart", gioHnag);
		return "trang-gio-hang";
	}

	@RequestMapping("/cart/remove")
	public String XoaGioHang(Model model, HttpSession session, @RequestParam("id") int id) {
		HashMap<Integer, Integer> list = (HashMap<Integer, Integer>) session.getAttribute("listOrderDetail");
		List<trannguyenhoangnam.btl.Entity.GioHang> gioHnag = (List<trannguyenhoangnam.btl.Entity.GioHang>) session.getAttribute("cart");
		list.remove(id);
		System.out.println(gioHnag.get(0).getProduct().getNameProduct());
		session.setAttribute("cart", gioHnag);

		return "redirect:/cart";
	}

	@RequestMapping("/thanhtoan")
	public String thanhToanCart(Model model, HttpSession session) {
		Set<OrderDetail> listod = new HashSet<OrderDetail>();
		int id = (int) session.getAttribute("userId");
		System.out.println("id: " + id);
		User user = userdao.getUser(id);
		Order o = new Order(LocalDate.now(), new User(id, null, null, null, null, null, null), null);
		List<trannguyenhoangnam.btl.Entity.GioHang> gioHnag = (List<trannguyenhoangnam.btl.Entity.GioHang>) session.getAttribute("cart");
		boolean loginFailed = (boolean) session.getAttribute("loginFailed");
		if (loginFailed == false) {

			return "redirect:/cart";
		}
		for (trannguyenhoangnam.btl.Entity.GioHang h : gioHnag) {
			Product p = prodao.getProductById(h.getProduct().getIdProduct());
			int soluongupdate = p.getSoluong() - h.getSoluong();
			if (soluongupdate < 0) {
				model.addAttribute("errquantity","Sản Phẩm " + p.getNameProduct() + " hiện chỉ còn  " + p.getSoluong());
				return "trang-gio-hang";
			}
			p.setSoluong(soluongupdate);
			prodao.update(p);
			OrderDetail oddt = new OrderDetail(p, o, h.getSoluong(), p.getPrice() * h.getSoluong());
			listod.add(oddt);
		}
		o.setOrdetail(listod);

		orderdao.addOrder(o);
		SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getUsername());
        message.setSubject("Mua Hàng Thành Công");
        message.setText("Cảm Ơn bạn "+user.getHoTen()+" Đã mua Hàng Thành Công! Vui Lòng Kiểm Trả Hóa Đơn Trong Tài Khoản");

        mailSender.send(message);
		HashMap<Integer, Integer> list = (HashMap<Integer, Integer>) session.getAttribute("listOrderDetail");
		list.clear();
		

		return "redirect:/home";
	}
}
