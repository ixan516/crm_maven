package cn.ixan.crm.customer.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.ixan.crm.customer.dao.CustomerDao;
import cn.ixan.crm.customer.domain.Customer;
import cn.ixan.crm.utils.PageBean;

/**
* @author 天之骄子
* @date 2017年10月31日
* @version V1.0
*/
@SuppressWarnings("all")
@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	/**
	 * 查询总纪录数
	 */
	@Override
	public int getTotalRecords(DetachedCriteria criteria) {
		criteria.setProjection(Projections.rowCount());
		List<Long> totalRecord = (List<Long>) hibernateTemplate.findByCriteria(criteria);
		criteria.setProjection(null);
		return totalRecord.get(0).intValue();
	}
	/**
	 * 获取当前页的用户信息集+条件
	 */
	@Override
	public List<Customer> getCustomerResults(DetachedCriteria criteria, PageBean<Customer> pageBean) {
		List<Customer> result = (List<Customer>) hibernateTemplate.findByCriteria(criteria, pageBean.getStartIndex(), pageBean.getPageSize());
		return result;
	}
	
	
	/**
	 * 获取当前页的用户信息集
	 */
	
	@Override
	public List<Customer> findAllResults(DetachedCriteria criteria) {
		List<Customer> list = (List<Customer>) hibernateTemplate.findByCriteria(criteria);
		return list;
	}
	
	/**
	 * 修改客户信息
	 */
	@Override
	public void modifyCustomerInfo(Customer customer) {
		hibernateTemplate.update(customer);
	}
	
	/**
	 * 查询客户信息
	 */
	@Override
	public Customer queryCustomerById(Long custId) {
		Customer customer = hibernateTemplate.get(Customer.class, custId);
		return customer;
	}
	
	
	/**
	 * 删除Customer
	 */
	@Override
	public void delCustomer(Customer customer) {
		hibernateTemplate.delete(customer);
	}
	
	
	
	/**
	 * 查询所有Customer
	 */
	@Override
	public List<Customer> findAll() {
		List<Customer> list = (List<Customer>) hibernateTemplate.find("from Customer");
		return list;
	}
	
	/**
	 * 添加Customer
	 */
	@Override
	public void add(Customer customer) {
		hibernateTemplate.save(customer);
	}
	
}
