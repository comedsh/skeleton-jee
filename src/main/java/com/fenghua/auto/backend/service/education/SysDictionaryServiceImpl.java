package com.fenghua.auto.backend.service.education;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.SysDictionaryDao;
import com.fenghua.auto.backend.domain.education.SysDictionary;

@Service
public class SysDictionaryServiceImpl implements SysDictionaryService {

	@Autowired
	private SysDictionaryDao sysDictionaryDao;
	
//	@Transactional
	public void testTransactionalSuccessCase() throws RuntimeException {
		SysDictionary dic = new SysDictionary();
		dic.setDicGroup("groupTransactional");
		dic.setDicId("idTransactional");
		dic.setDicName("nameTransactional");
		dic.setDicOrder(12345);
		dic.setDicParentId("parendIdTransactional");
		dic.setDicValue("valueTransactional");
		sysDictionaryDao.insert(dic);
	}
	
//	@Transactional
	public void testTransactionalFailCase() throws RuntimeException {
		SysDictionary dic = new SysDictionary();
		dic.setDicGroup("groupTransactional");
		dic.setDicId("idTransactional");
		dic.setDicName("nameTransactional");
		dic.setDicOrder(12345);
		dic.setDicParentId("parendIdTransactional");
		dic.setDicValue("valueTransactional");
		sysDictionaryDao.insert(dic);
		
		throw new RuntimeException();
	}
}
