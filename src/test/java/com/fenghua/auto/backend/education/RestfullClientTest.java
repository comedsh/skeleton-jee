package com.fenghua.auto.backend.education;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fenghua.auto.backend.domain.education.Spittle;

/**
 * Notice, before you start this test case, don't forgot starting your web server.
 * 
 * @author shang yang
 *
 * @version 
 *
 * @createTime：2015年9月9日 下午4:35:57 
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-context.xml", "/spring-mybatis.xml"})
public class RestfullClientTest {
	
	@Test
	public void getSpittleByUsername(){
		
	}
	
	/**
	 * 
	 * 该测试用例，要重点掌握的是，是如何通过不同的请求的类型，分发到不同的 SpittleRestfulController 对应的 GET 方法
	 * 
	 * 这里，调用的方法是
	 * 
		@RequestMapping(value = "/{id}", method = RequestMethod.GET, 
						headers = {"Accept=text/xml, application/json"} ) // indicates, the server only accept the xml or json request.
		public @ResponseBody Spittle getSpittle(@PathVariable("id") long id )
		
	 * 
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@Test
	public void getSpittleById_default() throws ClientProtocolException, IOException{
		
		long spittleid = 1001;		
		
		HttpClient httpClient = HttpClientBuilder.create().build(); // Notice: DefaultHttpClient is deprecated
		
		String url = "http://127.0.0.1:8080/spittle/" + spittleid;
		
		HttpGet getRequest = new HttpGet(url);
		
		getRequest.setHeader(new BasicHeader("Accept", "application/json")); // 发送 json 请求
		
		HttpResponse response = httpClient.execute(getRequest);
		
		HttpEntity entity = response.getEntity();
		
		ObjectMapper mapper = new ObjectMapper();
		
		Spittle spittle = mapper.readValue(entity.getContent(), Spittle.class);
		
		Assert.assertEquals("zhang san", spittle.getUsername());
		
		Assert.assertEquals("hi, I'm zhang san~", spittle.getText());		
	}
	
	/**
	 * uses the RestTemplate for simplification.
	 */
	@Test
	public void getSpittleById_simple(){
		
		// sufficiently replace the web service or some other RPC calls.
		Spittle spittle = new RestTemplate().getForObject("http://127.0.0.1:8080/spittle/{id}", Spittle.class, 1001);
		
		Assert.assertEquals("zhang san", spittle.getUsername());
		
		Assert.assertEquals("hi, I'm zhang san~", spittle.getText());
		
	}
	
}
