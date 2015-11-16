package com.fenghua.auto.webapp.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fenghua.auto.backend.domain.user.Company;
import com.fenghua.auto.backend.domain.user.User;
import com.fenghua.auto.backend.service.user.CompanyService;
/**
 * 企业
 * @author chengbin
 *
 */
@Controller
@RequestMapping("/company")
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	/**
	 * 通过固定电话查询
	 * @param email
	 * @param req
	 * @param res
	 */
	@RequestMapping(value = "/validateFixed", method = RequestMethod.POST)
	public @ResponseBody List<Company> validateFixed(@RequestParam String fixed,  HttpServletRequest req, HttpServletResponse res) {
		return companyService.getUserByFixed(fixed);
	}
	/**
	 * 通过telephone查询
	 * @param email
	 * @param req
	 * @param res
	 */
	@RequestMapping(value = "/validateTelephone", method = RequestMethod.POST)
	public @ResponseBody List<Company> validateTelephone(@RequestParam String telephone,  HttpServletRequest req, HttpServletResponse res) {
		return companyService.getContactsTelephone(telephone);
	}
	/**
	 * 通过contacts_email查询
	 * @param email
	 * @param req
	 * @param res
	 */
	@RequestMapping(value = "/validateEmail", method = RequestMethod.POST)
	public @ResponseBody List<Company> validateEmail(@RequestParam String email,  HttpServletRequest req, HttpServletResponse res) {
		return companyService.getCompanyByEmail(email);
	}
}
