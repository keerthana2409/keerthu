package com.devil.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.devil.dao.ProductDao;
import com.devil.models.Category;
import com.devil.models.Product;

@Controller
public class ProductController {
	@Autowired
	private ProductDao productDao;
	public ProductController() {
		System.out.println("Product Controller bean is created");
	}
	@RequestMapping(value="/all/getallproducts")
	public String getAllProducts(Model model) {
		List<Product> products = productDao.getAllProducts();
		model.addAttribute("products",products);
		return "productlist";
	}
	@RequestMapping(value="/all/getallproducts/{category}")
	public String getCategoryProducts(Model model, @PathVariable String category) {
		List<Product> products = productDao.getCategoryProducts(category);
		model.addAttribute("products",products);
		return "productlist";
	}
@RequestMapping("/all/getproduct")
	public String getProduct(@RequestParam int id, Model model) {
		Product product = productDao.getProduct(id);
		model.addAttribute("productAttr",product);
		return "viewproduct";
		
	}
	@RequestMapping(value="/admin/deleteproduct/{id}")
	public String deleteProduct(@PathVariable int id,HttpServletRequest request){
		Path paths=
				Paths.get(request.getServletContext().getRealPath("/")+"/WEB-INF/resources/images/"+id+".png");
				if(Files.exists(paths)){
					try {
						Files.delete(paths);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		productDao.deleteProduct(id);
		return "redirect:/all/getallproducts";	
	}
	@RequestMapping(value="/admin/getproductform")
	public String getProductform(Model model){
		Product p=new Product();
		model.addAttribute("product",p);
		List<Category> categories=productDao.getAllCategories();
		model.addAttribute("categories",categories);
		return "productform";
	}
	@RequestMapping(value="/admin/addproduct")
	public String addProduct(@ModelAttribute @Valid Product product,BindingResult result,Model model,HttpServletRequest request) {
		if(result.hasErrors()) {
			model.addAttribute("categories",productDao.getAllCategories());
		return "productform";
		}
		productDao.saveOrUpdate(product);
		System.out.println(request.getServletContext().getRealPath("/"));
		Path path=Paths.get(request.getServletContext().getRealPath("/")+"/WEB-INF/resources/images/"+product.getId()+".png");
		MultipartFile img=product.getImage();
		if(img!=null&&!img.isEmpty()) {
			File file=new File(path.toString());
			try {
				img.transferTo(file);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		return "redirect:/all/getallproducts";
		}
    @RequestMapping(value="/admin/getupdateform")
	public String getupdateform(@RequestParam int id,Model model){
		Product product=productDao.getProduct(id);
		model.addAttribute("product",product);
		System.out.println("BEFORE GETTING FORM " +product.getId());
		List<Category> categories=productDao.getAllCategories();
		model.addAttribute("categories",categories);
		return "updateproductform";
}
    @RequestMapping (value="/admin/updateproduct")
    public String updateproduct(@ModelAttribute @Valid Product product,BindingResult result, Model model,HttpServletRequest request) {
    	if(result.hasErrors()) {
    		model.addAttribute("categories",productDao.getAllCategories());
    		return "updateproductform";
    	}
    	System.out.println(request.getServletContext().getRealPath("/"));
    	Path path=Paths.get(request.getServletContext().getRealPath("/")+"/WEB-INF/resources/images/"+product.getId()+".png");
    	MultipartFile img=product.getImage();
    	if(img!=null&&!img.isEmpty()) {
    		File file=new File(path.toString());
    		try {
    			img.transferTo(file);
    		} catch (IllegalStateException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
    	productDao.saveOrUpdate(product);
		return "redirect:/all/getallproducts";
    }
}