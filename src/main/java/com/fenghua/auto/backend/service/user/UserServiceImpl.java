package com.fenghua.auto.backend.service.user;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.user.CompanyDao;
import com.fenghua.auto.backend.dao.user.PaymentTypeDao;
import com.fenghua.auto.backend.dao.user.UserDao;
import com.fenghua.auto.backend.dao.user.UserPaymentTypeDao;
import com.fenghua.auto.backend.domain.user.Company;
import com.fenghua.auto.backend.domain.user.Payment_type;
import com.fenghua.auto.backend.domain.user.User;
import com.fenghua.auto.backend.domain.user.User_payment_type;

/**
 * 个人注册接口实现
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PaymentTypeDao paymentTypeDao;
	
	@Autowired
	private CompanyDao companyDao;
	
	@Autowired
	private UserPaymentTypeDao usercompanyDao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;


	@Override
	public void delete(Long id) {
		userDao.deleteById(id);
	}

	@Override
	public void update(User personal) {
		userDao.updateById(personal);
	}

	@Override
	public void insert(User personal) {
		String passWord = encoder.encode( personal.getPassword());
		personal.setPassword(passWord);
		userDao.insert(personal);
	}
	@Override
	public void insert(User personal, Company company, Payment_type payment) {
		//企业数据
		Long companyId = companyDao.getCompanyId(company);
		//支付数据
		String str = payment.getTypename();
		if(str.equals("0")) {
			payment.setTypename("月结");
		} else if(str.equals("1")) {
			payment.setTypename("季结");
		}
		payment.setNeedapprove("Y");
		payment.setCreatedTs(new Date());
		Long paymentId = paymentTypeDao.getPaymentId(payment);
		//个人数据
		String passWord = encoder.encode( personal.getPassword());
		personal.setPassword(passWord);
		personal.setCompany(companyId);
		Long userId = userDao.getPaymentId(personal);
		//user与支付关系数据
		User_payment_type payment_type = new User_payment_type();
		payment_type.setUserId(userId);
		payment_type.setStatus(0);
		payment_type.setPaymenttypeId(paymentId);
		usercompanyDao.insert(payment_type);
	}

	@Override
	public User getUserById(Long id) {
		return userDao.selectById(id);
	}

	@Override
	public List<User> getAll() {
		return userDao.selectAll();
	}

	@Override
	public List<User> getUserByName(String name) {
		return userDao.selectByName(name);
	}
	
	@Override
	public List<User> getUserByEmail(String email) {
		return userDao.selectByEmail(email);
	}
	
	@Override
	public List<User> getUserByTelephone(String telephone) {
		return userDao.selectByTelephone(telephone);
	}
	@Override
	public List<Company> getUserByFixed(String fixed) {
		return userDao.selectByFixed(fixed);
	}
	
}
