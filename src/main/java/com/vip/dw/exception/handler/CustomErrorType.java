/**
 * 
 */
package com.vip.dw.exception.handler;

/**
 * @author fang08.li
 *
 */
public class CustomErrorType {
	
	private int status;
	
	
	private String trace;
	
	
	public CustomErrorType(int status,String trace){
		
		this.status=status;
		
		this.trace=trace;
		
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getTrace() {
		return trace;
	}


	public void setTrace(String trace) {
		this.trace = trace;
	}
	
	

}
