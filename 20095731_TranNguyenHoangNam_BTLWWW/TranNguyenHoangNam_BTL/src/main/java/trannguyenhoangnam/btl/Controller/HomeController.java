
package trannguyenhoangnam.btl.Controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import trannguyenhoangnam.btn.DAO.OrderDao;
import trannguyenhoangnam.btn.DAO.ProductDao;

@Controller
public class HomeController {
	@Autowired
	public ProductDao productDao;
	@Autowired
	public OrderDao orderDao;

	@RequestMapping("/")
	public String getHome(Model model, HttpSession ss) {
//		HashMap<Integer, Integer> list = new HashMap<Integer, Integer>();
//		ss.setAttribute("listOrderDetail", list);
		ss.setAttribute("userSecurity", false);
		ss.setAttribute("loginFailed", false);
		ss.setAttribute("listSP", productDao.getAllProduct(0));
		ss.setAttribute("numprd", 0);

		return "Home";
	}

	@RequestMapping("/home")
	public String goHome(Model model, HttpSession ss) {
//		HashMap<Integer, Integer> list ;= new HashMap<Integer, Integer>();
//		if (list == null) {
//			
//		}
//		ss.setAttribute("listOrderDetail", list);
		ss.setAttribute("listSP", productDao.getAllProduct(0));
		ss.setAttribute("numprd", 0);
		return "Home";
	}
}
