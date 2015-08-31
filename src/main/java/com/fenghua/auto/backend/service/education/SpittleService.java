package com.fenghua.auto.backend.service.education;

import java.util.List;

import com.fenghua.auto.backend.domain.education.Spittle;

/**
 * 用于培训用途
 * 
 * @author shang yang
 *
 * @version 
 *
 * @createTime：2015年8月31日 上午9:00:03 
 *
 */

public interface SpittleService {

	public Spittle getSpittleById(long id);
	
	public List<Spittle> getAllSpittles();
	
}
