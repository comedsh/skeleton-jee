package com.fenghua.auto.backend.dao.constants;

/**
 * Mybatis Sql脚本的ID名称
 */
public interface SqlId {
	//基本键
	public String SQL_SELECT_COUNT = "selectCount";
	public String SQL_SELECT = "select";
	public String SQL_SELECT_BY_ID = "selectByPrimaryKey";
	public String SQL_UPDATE_BY_ID = "updateByPrimaryKey";
	public String SQL_UPDATE_BY_ID_SELECTIVE = "updateByPrimaryKeySelective";
	public String SQL_DELETE = "delete";
	public String SQL_DELETE_BY_ID = "deleteByPrimaryKey";
	public String SQL_INSERT = "insert";
	public String SQL_INSERT_SELECTIVE = "insertSelective";
	
	
	//用户模块
	public String SQL_SELECT_BY_NAME = "selectByName";
	public String SQL_SELECT_BY_EMAIL = "selectByEmail";
	public String SQL_SELECT_BY_TELEPHONE = "selectByTelephone";
	
	
	//company模块
	public String SQL_SELECT_BY_FIXED = "selectByFixed";
}
