package controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.JstlView;

import entity.Book;
import service.Book_Service;
import service.Type_Service;
import utils.ReturnInfo;

@Controller
@RequestMapping("Book")
@SessionAttributes("user")
public class BookController {
	@Autowired
	Book_Service service;
	
	@Autowired
	Type_Service tservice;

	@ExceptionHandler
	public void sss(Exception e) {
		e.printStackTrace();
	}
	
	@RequestMapping("aaa")
	public ModelAndView dsd() {
		ModelAndView view=new ModelAndView();
		view.addObject("name", "¶øº«11¹ú");
		view.setViewName("Book/sss");
//		view.setView(new JstlView(url));
		return view;
	}
	
	
	@RequestMapping("sss")
	public  @ResponseBody String aaa(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest req )throws Exception {
		String oname=file.getOriginalFilename();
		String ex=oname.substring(oname.lastIndexOf("."),oname.length());
		String nname = UUID.randomUUID()+ex;

		String path=req.getSession().getServletContext().getRealPath("/");
		path=new File(path).getParentFile().getPath()+"/upload";
		System.out.println(path);
		file.transferTo(new File(path,nname));
		return "/upload/"+nname;
	}
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo  index( String txt,Integer page,Integer limit,ModelMap m) {
		if(txt!=null) txt=" where book.name like '%"+txt+"%'";
		else txt="";
		return service.select(txt,page,limit);
	}
	@RequestMapping("getSexs")
	public @ResponseBody String[]  getSexs() {
		return Book.sexs;
	}
	@RequestMapping("getTypes")
	public @ResponseBody List  getTypes() {
		return tservice.select("",null,null).getList();
	}
	
	@RequestMapping("insert")
	public @ResponseBody String  insert(Book b,ModelMap m) {
		service.insert(b);
		return "{\"status\":1}";
	}
	@RequestMapping("update")
	public  @ResponseBody String  update(Book b,ModelMap m) {
		service.update(b);
		return "{\"status\":1}";
	}
	@RequestMapping("edit")
	public  @ResponseBody Book  edit(int id,ModelMap m) {
		
		return service.selectById(id);
	}
	
	@RequestMapping("delete")
	public @ResponseBody String  delete(int id,ModelMap m) {
		service.delete(id);
		return "{\"status\":1}";
	}
}
