package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Type;
import service.Type_Service;
import utils.ReturnInfo;

@Controller
@RequestMapping("Type")
public class TypeController {
	@Autowired
	Type_Service service;

	@RequestMapping("index")
	public String   index1(Integer opt,String txt,Integer status,Integer page,Integer limit,ModelMap m) {
		String txt1="";
		if(opt!=null&&opt==1)
			txt1=" where type.status="+status;
		else
		if(txt!=null&&txt.length()>0)
			txt1=" where type.name like '%"+txt+"%'";
		m.put("list",service.select(txt1,page,limit)) ;
		m.put("statuslist", Type.statuslist);
		m.put("opt", opt);
		m.put("status", status);
		m.put("txt", txt);
		return "Type/index";
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
