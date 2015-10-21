package com.fenghua.auto.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.ModelAndViewAssert.assertViewName;

import org.easymock.EasyMock;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.fenghua.auto.backend.core.utills.SpringApplicationContext;
import com.fenghua.auto.demo.domain.DemoObj;
import com.fenghua.auto.demo.service.DemoService;
import com.fenghua.auto.demo.web.DemoController;
import com.fenghua.auto.test.AbstractControllerTest;


/** 
  *<des>
  *  测试demo, Controller 测试 继承 AbstractControllerTest 
  *</des>
  * @author  lijie
  * @date 2015年10月20日
  * @version 
  */
public class DemoControllerMockTest extends AbstractControllerTest{
	
	/**
	 * 使用Mock模拟 Service对象
	 * 
	 * @throws Exception
	 */
	@Test
	public void saveMock() throws Exception{
		
		//设置请求方法和URI以及参数
		jsonPostInit();
		request.setRequestURI("/demo_test/save");
		
		//创建mock对象，模拟service类
		DemoService demoService = EasyMock.createMock(DemoService.class);		
		//期望调用save 时返回1,可调用 多次
		EasyMock.expect(demoService.save()).andReturn(1).anyTimes();
		//创建 真实的测试对象，并创建依赖
	    EasyMock.replay(demoService);
	    
	    //获取demoController
	    DemoController demoController =  SpringApplicationContext.getBean("demoController");
	    demoController.setDemoService(demoService);
	  
	    //执行DemoController.saveMock() 方法
	    ModelAndView mav = excuteAction(request, response);
	    
	    //验证测试结果
		assertNotNull(mav);
		assertViewName(mav, "/successful");
		
		int result = (int) mav.getModel().get("result");
		assertEquals(1, result);
		
		//验证交互行为，比如记录的调用，调用的参数等，由mock 框架完成
		EasyMock.verify(demoService);
	}

   
	@Test
	public void testGetAll() throws Exception {	
		//初始化请求方式 
		jsonGetInit();
		
		//设置请求路径
		request.setRequestURI("/demo_test");
			
		ModelAndView mav = excuteAction(request, response);

		assertNotNull(mav);
		assertViewName(mav, "/successful");
	}
	
	
	@Test
	public void testGetInfoById() throws Exception{		
		jsonGetInit();
		request.setRequestURI("/demo_test/{id}");
		request.setParameter("id", "1");

		ModelAndView mav = excuteAction(request, response);

		assertNotNull(mav);
		assertViewName(mav, "/successful");	
	}

	@Test
    public void testSave() throws Exception{		
		DemoObj obj = new DemoObj();
	    obj.setId("1");
	    obj.setName("test");

		String json = getJsonString(obj);
		
		//初始化请求方式
		jsonPostInit();
		request.setRequestURI("/demo_test");
		//设置请求参数
		request.setContent(json.getBytes());

		ModelAndView mav = excuteAction(request, response);
		assertNotNull(mav);

		assertViewName(mav, "/successful");
		
		DemoObj demoInfo = 	(DemoObj) mav.getModel().get("demoInfo");
		assertNotNull(demoInfo);
		assertEquals("1", demoInfo.getId());

    }

	
	@Test
	public void delete() throws Exception{	
		
		jsonDelInit();
		request.setRequestURI("/demo_test/{id}");
		request.setParameter("id","1");
		
		ModelAndView mav = excuteAction(request, response);
		
		assertNotNull(mav);
		assertViewName(mav, "/successful");
	}
}

