package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Book;
import entity.Type;
import service.Book_Service;
import service.Type_Service;
import utils.ReturnInfo;
import utils.SqlUtils;

@Controller
@RequestMapping("Type")
public class TypeController {
	@Autowired
	Type_Service service;
	
	@Autowired
	Book_Service bservice;

	@RequestMapping("index")
	public String   index(Type t,Integer page,Integer limit,ModelMap m) {
		String txt1=SqlUtils.ObjectTowhere(t, "type");		
		m.put("list",service.select(txt1,page,limit)) ;
		List<Book> list=bservice.select("", null, null).getList();
		m.put("booklist",list );
		//获取最新的bookid
		int bookid=t.getBookid();
		if(bookid==0) bookid=list.get(0).getId();
		//
		m.put("typelist", service.select(" where type.bookid="+bookid, null, null).getList());
		m.put("info", t);
		return "Type/index";
	}
	@RequestMapping("gettypess")
	public @ResponseBody List  gettypess(int id,ModelMap m) {
		return service.select(" where type.bookid="+id, null, null).getList();
	}
	
	@RequestMapping("insert")
	public String  insert(Type b,ModelMap m) {
		service.insert(b);
		return index(0, null, null, m);
	}
	private String index(int i, Object object, Object object2, ModelMap m) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping("update")
	public   String  update(Type b,ModelMap m) {
		service.update(b);
		return index(0, null, null, m);
	}
	
	@RequestMapping("add")
	public  String  add(ModelMap m) {
		return "Type/index";
	}
	@RequestMapping("edit")
	public  String  edit(int id,ModelMap m) {
		m.put("info", service.selectById(id)) ;
		return add(m);
	}
	
	@RequestMapping("delete")
	public String  delete(int id,ModelMap m) {
		service.delete(id);
		return index(0, null, null, m);
	}
}
