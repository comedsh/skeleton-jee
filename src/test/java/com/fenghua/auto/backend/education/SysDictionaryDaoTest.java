package com.fenghua.auto.backend.education;

import java.util.ArrayList;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.fenghua.auto.backend.dao.SysDictionaryDao;
import com.fenghua.auto.backend.domain.education.SysDictionary;
import com.fenghua.auto.backend.domain.vo.education.SysDictionaryVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-context.xml", "/spring-mybatis.xml"})
@Transactional
public class SysDictionaryDaoTest {
	
	@Autowired
	private SysDictionaryDao sysDictionaryDao;
	
	@Test
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
	
	@Test
	public void testSelectById() {
		testInsert();
		SysDictionaryVo dicVo = sysDictionaryDao.selectById("id1");
		Assert.assertNotNull(dicVo);
		Assert.assertEquals("id1", dicVo.getDicId());
		Assert.assertEquals("name1", dicVo.getDicName());
	}

	@Test
	public void testSelectAll() {
		testInsert();
		List<SysDictionaryVo> dicVoList = sysDictionaryDao.selectAll();
		Assert.assertEquals(10, dicVoList.size());
	}

	@Test
	public void testSelectCount() {
		testInsert();
		long count = sysDictionaryDao.selectCount();
		Assert.assertEquals(10, count);
	}

	@Test
	public void testDeleteById() {
		testInsert();
		int count = sysDictionaryDao.deleteById("id5");
		Assert.assertEquals(1, count);
		SysDictionaryVo dicVo = sysDictionaryDao.selectById("id5");
		Assert.assertEquals(null, dicVo);
	}

	@Test
	public void testBatchDeleteById() {
		testInsert();
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
		testInsert();
		int count = sysDictionaryDao.deleteAll();
		Assert.assertEquals(10, count);
	}

}
