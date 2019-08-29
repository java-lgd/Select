package entity;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class Type  {
public static String[] statuslist= {"z1","z2","z3"};
public String getStatusname() {
	return statuslist[status];
}
	
	private int id;
	private String name;
	private int status;
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Type() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		System.out.println(111);
	}
	
	public Type(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
