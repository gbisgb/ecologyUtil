package com.gb.util;

import java.util.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String url = "http://www.e-cology.com.cn/ld";
		HttpPost httpPost = new HttpPost(url);
		
		 List<NameValuePair> list = new ArrayList<NameValuePair>(); 
		 list.add(new BasicNameValuePair("companyname","E8TEST"));
		 list.add(new BasicNameValuePair("errorUrl","/license2/CreateTemp80.jsp"));
		 list.add(new BasicNameValuePair("from","temp"));
		 list.add(new BasicNameValuePair("licensecode","B49FD2656F197D5A9B21D7A2AAE6F033"));
		 list.add(new BasicNameValuePair("licensetype","ecology8"));
		 //list.add(new BasicNameValuePair("licensetype","emobile6"));
		 list.add(new BasicNameValuePair("scType","1"));
		 list.add(new BasicNameValuePair("usercountconcurrent","0"));
		 list.add(new BasicNameValuePair("usercounttype","1"));
		 //list.add(new BasicNameValuePair("licensetype","ecology8"));
		 
		 UrlEncodedFormEntity entity;
		try {
			entity = new UrlEncodedFormEntity(list,"utf-8");
			httpPost.setEntity(entity); 
			HttpClient httpClient = new DefaultHttpClient();  
			 HttpResponse response = httpClient.execute(httpPost);  
	            if(response != null){  
	                HttpEntity resEntity = response.getEntity();  
	                if(resEntity != null){  
	                    FileOutputStream output = new FileOutputStream(new File("D:\\test.license"));
	                    byte[] buffer = new byte[1024];
	                    int byteread = 0;
	                    while((byteread = resEntity.getContent().read(buffer)) != -1) {
	                    	output.write(buffer, 0, byteread);
	                    	output.flush() ;
				        }
	                }  
	            }
		} catch (Exception e) {
			e.printStackTrace();
		}  
         
	}

}