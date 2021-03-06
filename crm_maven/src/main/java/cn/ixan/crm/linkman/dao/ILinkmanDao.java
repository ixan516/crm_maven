package cn.ixan.crm.linkman.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.ixan.crm.customer.domain.Customer;
import cn.ixan.crm.linkman.domain.Linkman;
import cn.ixan.crm.utils.PageBean;

/**
* @author 天之骄子
* @date 2017年11月14日
* @version V1.0
*/
public interface ILinkmanDao {
	/**
	 * 查询所有客户
	 * @return
	 */
	List<Customer> findAllCustomer();
	/**
	 * 保存联系人
	 * @param linkman
	 */
	void saveLinkman(Linkman linkman);
	/**
	 * 查询所有联系人
	 * @return
	 */
	List<Linkman> findAllLinkman();
	
	/**
	 * 查询联系人
	 * @param lkmId
	 * @return
	 */
	Linkman queryLinkmanById(Long lkmId);
	/**
	 * 修改联系人信息
	 * @param linkman
	 */
	void modifyLinkmanInfo(Linkman linkman);
	/**
	 * 删除联系人
	 * @param link
	 */
	void delLinkman(Linkman link);
	/**
	 * 查询联系人总纪录数
	 * @param criteria 
	 * @return
	 */
	int getTotalRecords(DetachedCriteria criteria);
	/**
	 * 查询当前页联系人
	 * @param criteria 
	 * @param pageBean
	 * @return
	 */
	List<Linkman> getLinkmanResults(DetachedCriteria criteria, PageBean<Linkman> pageBean);

}
