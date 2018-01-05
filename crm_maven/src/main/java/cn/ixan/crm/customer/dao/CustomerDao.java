package cn.ixan.crm.customer.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.ixan.crm.customer.domain.Customer;
import cn.ixan.crm.utils.PageBean;

/**
* @author 天之骄子
* @date 2017年10月31日
* @version V1.0
*/
public interface CustomerDao {
	/**
	 * 添加Customer
	 * @param customer
	 */
	void add(Customer customer);
	/**
	 * 查询所有Customer
	 * @return
	 */
	List<Customer> findAll();
	/**
	 * 删除Customer
	 * @param customer
	 */
	void delCustomer(Customer customer);
	/**
	 * 查询客户信息
	 * @param custId
	 * @return
	 */
	Customer queryCustomerById(Long custId);
	/**
	 * 修改用户信息
	 * @param customer
	 */
	void modifyCustomerInfo(Customer customer);
	/**
	 * 查询用户的总记录数
	 * @param criteria 
	 * @return
	 */
	int getTotalRecords(DetachedCriteria criteria);
	/**
	 * 获取当前页的用户信息集
	 * @param criteria 
	 * @param pageBean
	 * @return
	 */
	List<Customer> getCustomerResults(DetachedCriteria criteria, PageBean<Customer> pageBean);
	/**
	 * 条件查询用户信息
	 * @param criteria
	 * @return
	 */
	List<Customer> findAllResults(DetachedCriteria criteria);

}
