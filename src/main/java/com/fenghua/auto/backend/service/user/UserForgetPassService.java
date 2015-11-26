package com.fenghua.auto.backend.service.user;

import java.util.List;

import com.fenghua.auto.backend.domain.user.ResetPassRequest;

public interface UserForgetPassService {
	/**
	 * 保存
	 * @param resetPassRequest
	 */
	public void insert(String email);
	public List<ResetPassRequest> selectByCodeAndUser(String certificateCode,Long UserId); 
	/**
	 * 根据用户删除找回密码信息
	 * @param UserId
	 */
	public void deleteByUserId(Long UserId);
}
