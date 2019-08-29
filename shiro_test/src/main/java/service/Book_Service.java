package service;

import java.util.List;


import entity.Book;
import utils.ReturnInfo;

public interface Book_Service {
	
	public ReturnInfo select(String txt,Integer page,Integer limit);
	
	public Book selectById(int id);
	
	public void insert(Book t);
	
	public void update(Book t);
	
	public void delete(int id);
}
