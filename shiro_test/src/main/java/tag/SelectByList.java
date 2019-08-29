package tag;

import java.lang.reflect.Field;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SelectByList extends TagSupport{
	private String name;
	private boolean all=false;
	private int current;
	private List<?> items;
	private String myid="id";
	private String myname="name";
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public boolean isAll() {
		return all;
	}


	public void setAll(boolean all) {
		this.all = all;
	}


	public int getCurrent() {
		return current;
	}


	public void setCurrent(int current) {
		this.current = current;
	}


	

	public List<?> getItems() {
		return items;
	}


	public void setItems(List<?> items) {
		this.items = items;
	}


	public String getMyid() {
		return myid;
	}


	public void setMyid(String myid) {
		this.myid = myid;
	}


	public String getMyname() {
		return myname;
	}


	public void setMyname(String myname) {
		this.myname = myname;
	}


	@Override
	public int doStartTag() throws JspException {
		JspWriter w=pageContext.getOut();
		try {
		w.append("<select name='"+name+"'>");
		if(all) {
			w.append("<option value='-1'>È«²¿</option>");
		}
		for(int i=0;i<items.size();i++) {
			Object o=items.get(i);
			Field f1=o.getClass().getDeclaredField(myid);
			f1.setAccessible(true);
			int cid=(Integer)f1.get(o);
			Field f2=o.getClass().getDeclaredField(myname);
			f2.setAccessible(true);
			String cname=f2.get(o).toString();
			String select="";
			
			
;			if(cid==current) select=" selected='selected'";
			w.append("<option value='"+cid+"' "+select+">"+cname+"</option>");
		}
		w.append("</select>");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
}
