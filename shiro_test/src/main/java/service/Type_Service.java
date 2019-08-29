package service;

import java.util.List;


import entity.Type;
import utils.ReturnInfo;

public interface Type_Service {
	
	public ReturnInfo select(String txt,Integer page,Integer limit);
	
	public Type selectById(int id);
	
	public void insert(Type t);
	
	public void update(Type t);
	
	public void delete(int id);
}
