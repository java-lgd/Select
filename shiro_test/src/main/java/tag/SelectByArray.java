package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SelectByArray extends TagSupport{
	private String name;
	private boolean all=false;
	private int current;
	private String[] items;
	
	
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


	public String[] getItems() {
		return items;
	}


	public void setItems(String[] items) {
		this.items = items;
	}


	@Override
	public int doStartTag() throws JspException {
		JspWriter w=pageContext.getOut();
		try {
		w.append("<select name='"+name+"'>");
		if(all) {
			w.append("<option value='-1'>È«²¿</option>");
		}
		for(int i=0;i<items.length;i++) {
			String select="";
			if(i==current) select=" selected='selected'";
			w.append("<option value='"+i+"' "+select+">"+items[i]+"</option>");
		}
		w.append("</select>");
		}catch (Exception e) {
		}
		return SKIP_BODY;
	}
}
