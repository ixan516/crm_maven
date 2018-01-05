package cn.ixan.crm.customer.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.ixan.crm.customer.domain.Customer;
import cn.ixan.crm.utils.PageBean;

/**
* @author 天之骄子
* @date 2017年10月31日
* @version V1.0
*/
public interface ICustomerService {
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
	 * 修改客户信息
	 * @param customer
	 */
	void modifyCustomerInfo(Customer customer);
	/**
	 * 分页查询所有用户信息
	 * @param pageBean
	 * @return
	 */
	PageBean<Customer> findAllCustomerForPages(PageBean<Customer> pageBean);
	/**
	 * 条件查询用户信息
	 * @param criteria
	 * @return
	 */
	List<Customer> findAllResults(DetachedCriteria criteria);
	/**
	 * 条件+分页查询用户信息
	 * @param criteria
	 * @param pageBean
	 * @return
	 */
	PageBean<Customer> findAllResults(DetachedCriteria criteria, PageBean<Customer> pageBean);

}
