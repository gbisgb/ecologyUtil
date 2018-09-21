package com.gb.util;

import java.util.*;

public class SqlUtil {

	public static String  insertSqlcreate(String tablename,List valList){
		
		Iterator it=valList.iterator();
		String nameString="";
		String valueSgtring="";
		
		while(it.hasNext()){
		
			VField vf=(VField)it.next();
			nameString=nameString+vf.name+",";
			
			if (vf.type==vf.TYPE_SQL_VALE){
				valueSgtring+=vf.value+",";
			}else if (vf.type==vf.TYPE_TEXT_VALE){
				valueSgtring+="'"+vf.value+"',";
			}
			
		}
		
		nameString=nameString.substring(0, nameString.length()-1);
		
		valueSgtring=valueSgtring.substring(0, valueSgtring.length()-1);
		
		String retrunSql="insert into "+tablename+"("+nameString+") values ("+valueSgtring+")";
		
		
		return retrunSql;
		
	}

	public static void main(String[] args) {
		
		List vflist=new ArrayList();
		
		vflist.add(new VField("AAA", "a1") );
		vflist.add(new VField("BBB", "sysdate()",VField.TYPE_SQL_VALE) );
		
		
		System.out.println(insertSqlcreate("formtable", vflist));
		
		// TODO Auto-generated method stub

	}

}

