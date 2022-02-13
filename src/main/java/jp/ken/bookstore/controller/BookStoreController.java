package jp.ken.bookstore.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.ken.bookstore.dao.AuthorDAO;
import jp.ken.bookstore.dao.ProductDAO;
import jp.ken.bookstore.entity.Author;
import jp.ken.bookstore.entity.Product;
import jp.ken.bookstore.model.BookStoreModel;

@Controller
public class BookStoreController {
	private static ApplicationContext context = new ClassPathXmlApplicationContext("bookstore.xml");
	@SuppressWarnings("unchecked")
	private static AuthorDAO<Author> authorDAO = (AuthorDAO<Author>)context.getBean("authorDAO");
	
	@SuppressWarnings("unchecked")
	private static ProductDAO<Product> productDAO = (ProductDAO<Product>)context.getBean("productDAO");
	
	@RequestMapping(value = "index",method = RequestMethod.GET)
	public String shwoIndex(BookStoreModel bookStoreModel) {
		return "index";
	}
	
	@RequestMapping(value = "allList",method = RequestMethod.GET)
	public String showAllList(BookStoreModel bookStoreModel) {
		return "allList";
	}
	
	@RequestMapping(value = "allList",method = RequestMethod.POST)
	public String showAllList(BookStoreModel bsm,Model model) {
		if(bsm.getSelectRadio().equals("A")) {
			List<Author> list = authorDAO.allList();
			model.addAttribute("authorList", list);
			return "allList";
		}else if(bsm.getSelectRadio().equals("P")){
			List<Product> list = productDAO.allListOrderBy();
			model.addAttribute("productList",list);
		}
		return "allList";
	}
	
	@RequestMapping(value = "vagueList",method = RequestMethod.GET)
	public String showVagueList(BookStoreModel bookStoreModel) {
		return "vagueList";
	}
	
	@RequestMapping(value = "vagueList",method = RequestMethod.POST)
	public String showVagueList(@Validated BookStoreModel bsm,BindingResult result ,Model model) {
		if(result.hasErrors()) {
			//model.addAttribute("bookStoreModel",bsm);
			return "vagueList";
		}
		List<Product> list = productDAO.likeList(bsm.getVagueFiled());
		if(list.size() > 0) {
			model.addAttribute("productList",list);
		}else {
			
			model.addAttribute("noData", "no data...");
		}
		
		return "vagueList";
	}
}
