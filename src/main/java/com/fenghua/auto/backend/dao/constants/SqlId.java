package com.fenghua.auto.backend.dao.constants;

/**
 * Mybatis Sql脚本的ID名称
 */
public interface SqlId {
	//基本键
	public String SQL_SELECT_COUNT = "selectCount";
	public String SQL_SELECT = "select";
	public String SQL_SELECT_PRIMARY_KEY = "selectByPrimaryKey";
	public String SQL_UPDATE_PRIMARY_KEY = "updateByPrimaryKey";
	public String SQL_UPDATE_PRIMARY_KEY_SELECTIVE = "updateByPrimaryKeySelective";
	public String SQL_DELETE = "delete";
	public String SQL_DELETE_PRIMARY_KEY = "deleteByPrimaryKey";
	public String SQL_INSERT = "insert";
	public String SQL_INSERT_SELECTIVE = "insertSelective";
	public String SQL_UPDATEPASSWORD_BY_PHONE = "updatePasswordByPhone";
	public String SQL_UPDATEPASSWORD_BY_USERID = "updatePasswordByUserId";
	//用户模块
	public String SQL_SELECT_BY_NAME = "selectByName";
	public String SQL_SELECT_BY_EMAIL = "selectByEmail";
	public String SQL_SELECT_BY_TELEPHONE = "selectByTelephone";
	public String SQL_UPDATE_BY_NAME = "updateFailtimesByName";
	public String SQL_SELECT_BY_USERID="selectByUserId";
	public String SQL_SELECT_BY_CONFIGNAME="selectByConfigName";

	//company模块
	public String SQL_SELECT_BY_FIXED = "selectByFixed";
	public String SQL_SELECT_BY_CONTACTSTELEPHONE = "selectByContactsTelephone";
	public String SQL_SELECT_BY_CONTACTSEMAIL = "selectByContactsEmail";
	
	//cityArea模块获取省份
	public String SQL_SELECT_BY_PROVINCE = "selectByProvince";
	//cityArea模块获取市级
	public String SQL_SELECT_BY_CITY = "selectByCity";
	//cityArea模块获取县级
	public String SQL_SELECT_BY_AREA = "selectByArea";
	//忘记密码模块
	public String SQL_SELECT_BY_CODEANDUSER="selectByCodeAndUser";
	public String SQL_DELETE_BY_USERID="deleteByUserId";
}
