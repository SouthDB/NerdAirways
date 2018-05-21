package myfunction;

import java.util.*;

public class makeJSNOBJ {
	
	public String jsnObj;
	
	public makeJSNOBJ(String name, List<String> list){
		this.jsnObj = "{\"" + name + "\":[";
		
		for (int i= 0; i < (list.size() -1); i++){
			jsnObj += list.get(i) + ",";
		}
		jsnObj += list.get((list.size() -1)) + "]}";
	}
	
	public String getJsnObj() {
		return jsnObj;
	}
	
	

}
