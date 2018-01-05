package cn.ixan.crm.customer.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ixan.crm.customer.dao.CustomerDao;
import cn.ixan.crm.customer.domain.Customer;
import cn.ixan.crm.customer.service.ICustomerService;
import cn.ixan.crm.utils.PageBean;

/**
* @author 天之骄子
* @date 2017年10月31日
* @version V1.0
*/
@Service("customerService")
@Transactional(rollbackFor=Exception.class)
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private CustomerDao customerDao ;

	/**
	 * 条件+分页查询所有用户信息
	 */
	
	@Override
	public PageBean<Customer> findAllResults(DetachedCriteria criteria, PageBean<Customer> pageBean) {
		// 1.查询总纪录数
		int totalRecord = customerDao.getTotalRecords(criteria);
		pageBean.setTotalRecord(totalRecord);
		// 2.查询当前页的客户信息
		List<Customer> result= customerDao.getCustomerResults(criteria,pageBean);
		pageBean.setResult(result);
		// 3.返回结果
		return pageBean;
	}

	
	/**
	 * 条件查询客户信息
	 */
	@Override
	public List<Customer> findAllResults(DetachedCriteria criteria) {
		return customerDao.findAllResults(criteria);
	}

	
	/**
	 * 修改客户信息
	 */
	@Override
	public void modifyCustomerInfo(Customer customer) {
		customerDao.modifyCustomerInfo(customer);
	}
	
	/**
	 * 查询客户信息
	 */
	@Override
	public Customer queryCustomerById(Long custId) {
		return customerDao.queryCustomerById(custId);
	}
	
	/**
	 * 通过id来删除Customer
	 */
	@Override
	public void delCustomer(Customer customer) {
		
		customerDao.delCustomer(customer);
		
	}
	
	/**
	 * 查询所有Customer
	 */
	@Override
	public List<Customer> findAll() {
		return customerDao.findAll();
	}
	
	
	/**
	 * 添加Customer
	 */
	@Override
	public void add(Customer customer) {
		customerDao.add(customer);
	}


	@Override
	public PageBean<Customer> findAllCustomerForPages(PageBean<Customer> pageBean) {
		return null;
	}


}
