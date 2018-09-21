package com.gb.util;

import java.util.ArrayList;
import java.util.List;

import weaver.conn.RecordSet;
import weaver.general.BaseBean;

/**
 * 综合工具类
 * 
 * @author GS
 * 
 */
public class GBUtil {

	/**
	 * 根据员工ID得到姓名
	 * 
	 * @param id
	 *            员工ID
	 * @return 姓名lastname
	 */
	public static String getHRNameBYid(String id) {
		String lastname = "";
		RecordSet rs = new RecordSet();
		rs.execute("select lastname from hrmresource where id='" + id + "'");
		if (rs.next()) {
			lastname = rs.getString("lastname");
		}
		return lastname;
	}

	/**
	 * 根据分部ID得到分部名字
	 * @param id
	 * @return 分部名字
	 */
	public static String getSubCompNameByid(String id) {

		String subcompanyname = "";
		RecordSet rs = new RecordSet();
		rs.execute("select subcompanyname from hrmsubcompany  where id='" + id + "'");
		if (rs.next()) {
			subcompanyname = rs.getString("subcompanyname");
		}
		return subcompanyname;
	}

	/**
	 * 
	 * @param id
	 *            部门ID
	 * @return 部门名字
	 */
	public static String getDeptNameByid(String id) {

		String deptname = "";
		RecordSet rs = new RecordSet();
		rs.execute("select departmentname from hrmdepartment  where id='" + id + "'");
		if (rs.next()) {
			deptname = rs.getString("departmentname");
		}
		return deptname;
	}

	/**
	 * OA根据部门编号得到部门ID
	 * 
	 * @param code
	 *            部门编号
	 * @return 部门id
	 */
	public static int getDeptidBYcode(String code) {
		int id = 0;
		RecordSet rs = new RecordSet();
		rs.execute("select id from hrmdepartment  where departmentcode='" + code + "'");
		if (rs.next()) {
			id = rs.getInt("id");
		}
		return id;
	}

	/**
	 * 根据工号得到用户ID
	 * 
	 * @param code
	 *            工号
	 * @return OA中的ID
	 */

	public static int getHRidBYcode(String code) {
		int id = 0;
		RecordSet rs = new RecordSet();
		rs.execute("select id from hrmresource where workcode='" + code + "'");
		if (rs.next()) {
			id = rs.getInt("id");
		}
		return id;
	}
	
	/**
	 * 
	 * @param id 附件ID
	 * @return 附件信息的打包LIST<BR> 
	 * 	    list.add(rs.getString("id"));<BR>
			list.add(rs.getString("docid"));<BR>
			list.add(rs.getString("imagefileid"));<BR>
			list.add(rs.getString("imagefilename"));<BR>
			list.add(rs.getString("filesize"));<BR>
	 */
	
	
	public static List getFileBYid(String id) {
		List list=new ArrayList();
		RecordSet rs = new RecordSet();
		rs.execute("select t1.id,t1.docid,t1.imagefileid,t1.imagefilename,t2.filesize from DocImageFile t1 left join ImageFile t2 on t1.imagefileid=t2.imagefileid  where t1.docid='"+id+"'");
		if (rs.next()) {
		
			list.add(rs.getString("id"));
			list.add(rs.getString("docid"));
			list.add(rs.getString("imagefileid"));
			list.add(rs.getString("imagefilename"));
			list.add(rs.getString("filesize"));
			
			
		}
		return list;
	}
	
	
	
	
	public static String getSelectVal(String sevel,String fieldid) {
		BaseBean bs = new BaseBean();
		RecordSet rs = new RecordSet();

		String getShenfengsql = "select selectname from workflow_selectitem where fieldid="+fieldid+" and selectvalue='"+sevel+"'";
		bs.writeLog("+++GBUtil+++getShenfengsql:" + getShenfengsql);
		rs.execute(getShenfengsql);
		String Shenfeng = "";
		if (rs.next()) {
			Shenfeng = rs.getString("selectname");
		}
		return Shenfeng;

	}
	


	
	
	public static String getDeptCodeByDeptId(String deptId) {

		RecordSet rs = new RecordSet();

		rs.execute("select departmentcode from  HrmDepartment  where id='" + deptId + "'");
		String departmentcode = "";
		if (rs.next()) {
			departmentcode = rs.getString("departmentcode");
		}
		return departmentcode;

	}



	public static int getUsedIDbyworkcode(String workcode) {
		BaseBean bs = new BaseBean();
		RecordSet rs = new RecordSet();

		String getUsedIDbyworkcodesql = "select id from hrmresource  where workcode='" + workcode + "'";
		bs.writeLog("+++GBUtil+++getUsedIDbyworkcodesql:" + getUsedIDbyworkcodesql);
		rs.execute(getUsedIDbyworkcodesql);
		int id = 0;
		if (rs.next()) {
			id = rs.getInt("id");
		}
		return id;

	}

	public static String getdeptNAMEbydeptcode(String deptcode) {
		BaseBean bs = new BaseBean();
		RecordSet rs = new RecordSet();

		String getdeptIDbydeptcodesql = "select * from  HrmDepartment  where departmentcode='" + deptcode + "'";
		bs.writeLog("+++GBUtil+++getdeptIDbydeptcodesql:" + getdeptIDbydeptcodesql);
		rs.execute(getdeptIDbydeptcodesql);
		String name = "";
		if (rs.next()) {
			name = rs.getString("departmentname");
		}
		return name;

	}

	public static int getdeptIDbydeptcode(String deptcode) {
		BaseBean bs = new BaseBean();
		RecordSet rs = new RecordSet();

		String getdeptIDbydeptcodesql = "select * from  HrmDepartment  where departmentcode='" + deptcode + "'";
		bs.writeLog("+++GBUtil+++getdeptIDbydeptcodesql:" + getdeptIDbydeptcodesql);
		rs.execute(getdeptIDbydeptcodesql);
		int id = 0;
		if (rs.next()) {
			id = rs.getInt("id");
		}
		return id;

	}

}
