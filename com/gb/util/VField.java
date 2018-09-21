package com.gb.util;

public class VField {
	public static final byte TYPE_TEXT_VALE = 0;
	public static final byte TYPE_SQL_VALE = 1;
	
	public  VField(String name,String value){
		this.name=name;
		this.value=value;
		this.type=VField.TYPE_TEXT_VALE;
	}
	
	public  VField(String name,String value,byte type){
		this.name=name;
		this.value=value;
		this.type=type;
	}



	public String name;
	public String value;
	public byte type;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public byte getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}

}
