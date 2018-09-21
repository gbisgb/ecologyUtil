package com.gb.util;

import weaver.conn.RecordSet;
import weaver.file.Prop;
import weaver.general.BaseBean;
import weaver.general.Util;
import weaver.interfaces.workflow.action.Action;
import weaver.interfaces.workflow.action.GB_Util;
import weaver.soa.workflow.request.RequestInfo;
import weaver.workflow.action.BaseAction;

public class MyBaseAction extends BaseAction{
	
	public BaseBean bs = new BaseBean();
	public Prop prop = Prop.getInstance();
	
	public String getWorkFlowBillTable(String workflowid) { // 得到表名封装方法
//		RecordSet rs = new RecordSet();
//		String return_Str = "";
//		if (null == workflowid || "".equals(workflowid)) {
//			return return_Str;
//		}
//		rs.executeSql("select tablename  from workflow_bill where id = (select formid from workflow_base where id= '" + workflowid + "' and isbill=1)");
//		if (rs.next()) {
//			return_Str = Util.null2String(rs.getString("tablename"));
//		}
	
		
		return 	getWorkFlowBillTableStatic(workflowid);
	}
	
	public void writeMyLog(String logString){
		
		bs.writeLog("+++++"+this.getClass().getSimpleName()+"+++"+logString);
		
	}
	
	
	
	protected String myError(RequestInfo request,String message) {
		
		writeMyLog("错误1:" + message);
		request.getRequestManager().setMessage(message);
		request.getRequestManager().setMessageid("1111111111");
		request.getRequestManager().setMessagecontent(message);
		return Action.SUCCESS;
		
	}
	
	

	public String getFormid(String workflowid) {// 得到formid 封装方法.
		RecordSet rs = new RecordSet();
		String return_Str = "";
		if (null == workflowid || "".equals(workflowid)) {
			return return_Str;
		}
		rs.execute("select formid from workflow_base where id = " + workflowid);
		rs.next();
		String formid = Util.null2String(rs.getString("formid"));
		return_Str = formid.replaceAll("-", "");
		return return_Str;
	}
	
	
	public static String getWorkFlowBillTableStatic(String workflowid) { // 得到表名封装方法
		RecordSet rs = new RecordSet();
		String return_Str = "";
		if (null == workflowid || "".equals(workflowid)) {
			return return_Str;
		}
		rs.executeSql("select tablename  from workflow_bill where id = (select formid from workflow_base where id= '" + workflowid + "' and isbill=1)");
		if (rs.next()) {
			return_Str = Util.null2String(rs.getString("tablename"));
		}
		return return_Str;
	}


}
