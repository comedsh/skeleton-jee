package com.fenghua.auto.backend.education;

import java.io.IOException;
import java.net.URI;

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
import org.springframework.http.ResponseEntity;
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
//	TODO 持续集成环境中 junit测试步骤暂时不考试涉及web交付的内容
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
//	@Test
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
//	@Test
	public void getSpittleById_simple(){
		
		// sufficiently replace the web service or some other RPC calls.
		Spittle spittle = new RestTemplate().getForObject("http://127.0.0.1:8080/spittle/{id}", Spittle.class, 1001);
		
		Assert.assertEquals("zhang san", spittle.getUsername());
		
		Assert.assertEquals("hi, I'm zhang san~", spittle.getText());
		
	}
	
//	@Test
	public void getSpittleByUsername(){
		
		// sufficiently replace the web service or some other RPC calls.
		Spittle[] spittles = new RestTemplate().getForObject("http://127.0.0.1:8080/spittle/{username}/spittles", Spittle[].class, "zhang san");
		
		for( Spittle s : spittles ){
			
			Assert.assertEquals("zhang san", s.getUsername());
		
		}
	}
	
//	@Test
	public void addSpittle(){
		
		Spittle spittle = new Spittle();
		
		spittle.setUsername("Spittler");
		
		spittle.setText("hi, I'm Spittler ~");		
		
		// scenario 1: postForObject
		
		Spittle s = new RestTemplate().postForObject( "http://localhost:8080/spittle", spittle, Spittle.class );
		
		Assert.assertEquals("Spittler", s.getUsername());
		
		Assert.assertEquals("hi, I'm Spittler ~", s.getText() );
		
		// scenario 2: postForEntity
		
		ResponseEntity<Spittle> e = new RestTemplate().postForEntity( "http://localhost:8080/spittle", spittle, Spittle.class );
		
		Spittle sp = e.getBody();
		
		URI url = e.getHeaders().getLocation();
		
		Assert.assertEquals("/spittle/"+sp.getId(), url.toString());
		
		// scenario 3: postForLocation
		
		url = new RestTemplate().postForLocation( "http://localhost:8080/spittle", spittle );
		
		Assert.assertEquals("/spittle/"+sp.getId(), url.toString());
	}
	
//	@Test
	public void updateSpittle(){

		Spittle spittle = new Spittle();
		
		spittle.setId(1001L);
		
		spittle.setUsername("zhang san update");
		
		spittle.setText("hi, I'm zhang san update ~");
		
		new RestTemplate().put("http://localhost:8080/spittle/{id}", spittle, spittle.getId() );		
		
	}
	
//	@Test
	public void deleteSpittle(){
		
		new RestTemplate().delete("http://localhost:8080/spittle/{id}", 1001L );
		
	}
	
}
