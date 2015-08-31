package com.fenghua.auto.backend.service.education;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.domain.education.Spittle;

/**
 * @author shang yang
 *
 * @version 
 *
 * @createTime：2015年8月31日 上午9:03:56 
 *
 */

@Service
public class SpittleServiceImpl implements SpittleService {

	
	static List<Spittle> mockSpittles = new ArrayList<Spittle>();
	
	static{
		
		Spittle s1 = new Spittle();
		s1.setId(1001L);
		s1.setUsername("zhang san");
		s1.setText("hi, I'm zhang san~");
		
		Spittle s2 = new Spittle();
		s2.setId(1002L);
		s2.setUsername("li si");
		s2.setText("hi, I'm li si~");
		
		Spittle s3 = new Spittle();
		s3.setId(1003L);
		s3.setUsername("wang ma zi");
		s3.setText("hi, I'm wang mazi~");		
		
		mockSpittles.add(s1);
		mockSpittles.add(s2);
		mockSpittles.add(s3);
		
	}
	
	
	public Spittle getSpittleById(long id) {
		
		Spittle spittle;
		
		for( Spittle s : mockSpittles ){
			if( s.getId() == id ){
				return s;
			}
		}
		
		return null;
	}

	public List<Spittle> getAllSpittles() {

		return mockSpittles;
	}

}
