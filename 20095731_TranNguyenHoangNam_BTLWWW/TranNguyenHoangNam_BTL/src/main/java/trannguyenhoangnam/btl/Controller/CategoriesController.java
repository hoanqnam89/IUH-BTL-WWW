package trannguyenhoangnam.btl.Controller;

import java.util.List;

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

import trannguyenhoangnam.btl.Entity.Categories;
import trannguyenhoangnam.btn.DAO.CategoriesDao;

@Controller
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    private CategoriesDao categoriesDao;

    @GetMapping("/list")
    public String listCategories(Model model) {
        List<Categories> categories = categoriesDao.getAllCategories();
        model.addAttribute("categories", categories);
        return "quan-li-categories";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Categories category = new Categories();
        model.addAttribute("categories", category);
        return "them-capnhat-categories";
    }

    @PostMapping("/saveCategories")
    public String saveCategory(@Valid @ModelAttribute("categories") Categories category, BindingResult rs) {
    	if (rs.hasErrors()) {
			return "them-capnhat-categories";
		}
        categoriesDao.save(category);
        return "redirect:/categories/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("categoriesId") int categoriesId, Model model) {
        Categories categories = categoriesDao.getOne(categoriesId);
        model.addAttribute("categories", categories);
        return "them-capnhat-categories";
    }

    
}

