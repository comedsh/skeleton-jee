package com.fenghua.auto.backend.education;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fenghua.auto.backend.dao.SysDictionaryDao;
import com.fenghua.auto.backend.domain.education.SysDictionary;
import com.fenghua.auto.backend.domain.vo.education.SysDictionaryVo;
import com.fenghua.auto.backend.service.education.SysDictionaryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-context.xml", "/spring-mybatis.xml"})
//@Transactional
public class SysDictionaryDaoTest {
	
	@Autowired
	private SysDictionaryDao sysDictionaryDao;
	@Autowired
	private SysDictionaryService sysDictionaryService;
	
	public void testInsert() {
		List<SysDictionary> dicList = new ArrayList<SysDictionary>();
		for (int i = 0; i < 10; i++) {
			SysDictionary dic = new SysDictionary();
			dic.setDicGroup("group" + i);
			dic.setDicId("id" + i);
			dic.setDicName("name" + i);
			dic.setDicOrder(i);
			dic.setDicParentId("parendId" + i);
			dic.setDicValue("value" + i);
			dicList.add(dic);
		}
		sysDictionaryDao.insertInBatch(dicList);
	}
	
	@Before
	public void before() {
		testInsert();
	}
	
	@After
	public void after() {
		sysDictionaryDao.deleteAll();
	}
	
	@Test
	public void testSelectById() {
		SysDictionaryVo dicVo = sysDictionaryDao.selectById("id1");
		Assert.assertNotNull(dicVo);
		Assert.assertEquals("id1", dicVo.getDicId());
		Assert.assertEquals("name1", dicVo.getDicName());
	}

	@Test
	public void testSelectAll() {
		List<SysDictionaryVo> dicVoList = sysDictionaryDao.selectAll();
		Assert.assertEquals(10, dicVoList.size());
	}

	@Test
	public void testSelectCount() {
		long count = sysDictionaryDao.selectCount();
		Assert.assertEquals(10, count);
	}

	@Test
	public void testDeleteById() {
		int count = sysDictionaryDao.deleteById("id5");
		Assert.assertEquals(1, count);
		SysDictionaryVo dicVo = sysDictionaryDao.selectById("id5");
		Assert.assertEquals(null, dicVo);
	}

	@Test
	public void testBatchDeleteById() {
		List<String> idList = new ArrayList<String>();
		idList.add("id5");
		idList.add("id6");
		idList.add("id7");
		idList.add("id8");
		sysDictionaryDao.deleteByIdInBatch(idList);
		SysDictionaryVo dicVo = sysDictionaryDao.selectById("id5");
		Assert.assertEquals(null, dicVo);
		SysDictionaryVo dicVo2 = sysDictionaryDao.selectById("id6");
		Assert.assertEquals(null, dicVo2);
		SysDictionaryVo dicVo3 = sysDictionaryDao.selectById("id7");
		Assert.assertEquals(null, dicVo3);
		SysDictionaryVo dicVo8 = sysDictionaryDao.selectById("id8");
		Assert.assertEquals(null, dicVo8);
	}

	@Test
	public void testDeleteAll() {
		int count = sysDictionaryDao.deleteAll();
		Assert.assertEquals(10, count);
	}
	
	
	@Transactional(rollbackFor=Exception.class) 
	public void testTransactionalSuccessCase() throws Exception {
		SysDictionary dic = new SysDictionary();
		dic.setDicGroup("groupTransactional");
		dic.setDicId("idTransactional");
		dic.setDicName("nameTransactional");
		dic.setDicOrder(12345);
		dic.setDicParentId("parendIdTransactional");
		dic.setDicValue("valueTransactional");
		sysDictionaryDao.insert(dic);
	}
	
	@Transactional(rollbackFor={RuntimeException.class, Exception.class},propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,readOnly=false) 
	public void testTransactionalFailCase() throws Exception {
		  try {   
			  SysDictionary dic = new SysDictionary();
				dic.setDicGroup("groupTransactional");
				dic.setDicId("idTransactional");
				dic.setDicName("nameTransactional");
				dic.setDicOrder(12345);
				dic.setDicParentId("parendIdTransactional");
				dic.setDicValue("valueTransactional");
				sysDictionaryDao.insert(dic);
			  throw new Exception();
		   } catch (Exception up) {   
		      throw up;   
		   }   
	}
	
	@Test
	public void testTransactionalSuccess(){
		try {
			sysDictionaryService.testTransactionalSuccessCase();
		} catch (Exception e) {
		}
		
		SysDictionaryVo dicVo = sysDictionaryDao.selectById("idTransactional");
		Assert.assertEquals("nameTransactional", dicVo.getDicName());
	}
	
	@Test
	public void testTransactionalFail(){
		try {
			sysDictionaryService.testTransactionalFailCase();
		} catch (Exception e) {
		}
		
		SysDictionaryVo dicVo = sysDictionaryDao.selectById("idTransactional");
		Assert.assertEquals(null, dicVo);
	}

}
