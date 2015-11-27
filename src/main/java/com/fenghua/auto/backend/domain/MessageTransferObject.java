package com.fenghua.auto.backend.domain;


/**
 * 
 * indicates the availability of message transferring
 * 
 * including the errors and messages
 * 
 * @author shang yang
 *
 * @version 
 *
 * @createTime：2015年11月26日 下午6:37:55 
 *
 */

public interface MessageTransferObject {
	
	public LabelError[] getErrors();
	
	public boolean hasError();
	
	//TODO
	public String[] getMessages();
	
	//TODO
	public boolean hasMessage();
	
	
}
