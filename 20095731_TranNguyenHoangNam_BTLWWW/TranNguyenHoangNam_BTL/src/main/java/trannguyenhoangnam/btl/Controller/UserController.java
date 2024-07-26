package trannguyenhoangnam.btl.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import trannguyenhoangnam.btl.DAO.impl.UserDaoimpl;
import trannguyenhoangnam.btl.Entity.User;

@Controller
public class UserController {
	@Autowired
	private UserDaoimpl userDaoimpl;

	@GetMapping("/admin/danhSachKhachHang")
	public String getUserController(Model theModel) {
		List<User> theUsers = userDaoimpl.getAllUser();
		// add the customers to the model
		theModel.addAttribute("users", theUsers);
		return "danh-sach-khach-hang";
	}

	@GetMapping("/user/dangKy")
	public String dangKy(Model theModel) {
		User user = new User();
		theModel.addAttribute("user", user);
		return "dang-ky-tai-khoan";
	}

	@PostMapping("/user/saveUser")
	public String saveCustomer(@Valid @ModelAttribute("user") User user,BindingResult bdrs, HttpSession session) {
		if (bdrs.hasErrors()) {
//			System.out.println("errêrêr");
			  return "dang-ky-tai-khoan"; 
		}
	    try {
	        userDaoimpl.saveUser(user);
	    } catch (RuntimeException e) {
	        // Đăng ký thất bại, tạo thông báo lỗi
	        String errorMessage = "Đăng ký tài khoản không thành công do trùng tài kHoản Vui lòng thử lại.";

	        // Lưu thông báo lỗi vào session
	        session.setAttribute("registrationError", errorMessage);

	        return "dang-ky-tai-khoan"; // Redirect đến trang đăng ký với thông báo lỗi
	    }
	    
	    return "dang-nhap"; // Nếu đăng ký thành công, chuyển hướng đến trang đăng nhập
	}


	@GetMapping("/user/dangNhap")
	public String dangNhap(Model theModel) {
		User user = new User();
		theModel.addAttribute("user", user);
		return "dang-nhap";
	}
	@GetMapping("/admin/delete")
	public String deleteCustomer(@RequestParam("id") int theId, Model theModel) {
		// delete the customer
		userDaoimpl.deleteUser(theId);
		List<User> theUsers = userDaoimpl.getAllUser();
		// add the customers to the model
		theModel.addAttribute("users", theUsers);
		return "danh-sach-khach-hang";
	}

	@GetMapping("/admin/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int theId, Model theModel) {
		// get the customer from our service
		User user = userDaoimpl.getUser(theId);
		// set customer as a model attribute to pre-populate the form
		// add cái này khi đăng nhập
		theModel.addAttribute("user", user);
		// send over to our form
		return "chinh-sua-khach-hang";
	}

	@PostMapping("/admin/updateUser")
	public String updateCustomer(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model theModel) {
		if (bindingResult.hasErrors()) {

			return "chinh-sua-khach-hang";
		}
		userDaoimpl.updateUser(user);
		List<User> theUsers = userDaoimpl.getAllUser();
		// add the customers to the model
		theModel.addAttribute("users", theUsers);
		return "danh-sach-khach-hang";
	}


	@PostMapping("/user/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
						@Valid @ModelAttribute("user") User user,BindingResult rs,
	                    HttpSession session, Model model) {
//		if (rs.hasErrors()) {
//			return "dang-nhap";
//		}
		if (username.equals("") || password.equals("") ) {
	    	return "dang-nhap";
		}
	    boolean isAdmin = userDaoimpl.isUserAdmin(username, password);
	    boolean isLogin = userDaoimpl.isLogin(username, password);
	    int id = userDaoimpl.getUserIdByUsernameAndPassword(username, password);

	    // Kiểm tra kết quả truy vấn
	    if (isAdmin && isLogin) {
	        System.out.println("đăng nhập thành công và là admin");
	        session.setAttribute("userSecurity", true);
	        session.setAttribute("loginFailed", true);
	        session.setAttribute("userId", id);
	        model.addAttribute("id", id);
	        return "Home";
	    } else if (isLogin) {
	        System.out.println("đăng nhập thành công nhưng không phải là admin");
	        session.setAttribute("userSecurity", false);
	        session.setAttribute("loginFailed", true);
	        session.setAttribute("userId", id);
	        model.addAttribute("id", id);
	        return "Home";
	    } else {
	        System.out.println("đăng nhập thất bại");
	        session.setAttribute("loginFailed", false);
	        return "dang-nhap";
	    }
	}

	@GetMapping("/user/logout")
	public String logout(HttpSession session) {
			session.setAttribute("loginFailed", false);
			return "Home";
	}
	@GetMapping("/user/thongTinCaNhan")
    public String thongTinCaNhan(HttpSession session, Model theModel) {
        // Kiểm tra xem session có tồn tại không
        if (session.getAttribute("userId") != null) {
            // Lấy giá trị ID từ session
            int userId = (int) session.getAttribute("userId");
            
            User user=userDaoimpl.findUserById(userId);
            theModel.addAttribute("user", user);

            // Trả về view "thong-tin-ca-nhan"
            return "thong-tin-ca-nhan";
        } else {
            // Nếu session không tồn tại, có thể chuyển hướng hoặc xử lý tùy thuộc vào logic của bạn
            return "redirect:/login"; // Ví dụ: chuyển hướng đến trang đăng nhập
        }
    }

}
