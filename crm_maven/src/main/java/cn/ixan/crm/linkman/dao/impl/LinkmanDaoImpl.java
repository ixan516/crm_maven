package cn.ixan.crm.linkman.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.ixan.crm.customer.domain.Customer;
import cn.ixan.crm.linkman.dao.ILinkmanDao;
import cn.ixan.crm.linkman.domain.Linkman;
import cn.ixan.crm.utils.PageBean;

/**
 * @author 天之骄子
 * @date 2017年11月14日
 * @version V1.0
 */
@Repository("linkmanDao")
@SuppressWarnings("all")
public class LinkmanDaoImpl implements ILinkmanDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	/**
	 * 查询所有用户
	 */
	@Override
	public List<Customer> findAllCustomer() {
		List<Customer> customerList = (List<Customer>) hibernateTemplate.find("from Customer");
		return customerList;
	}

	/**
	 * 保存联系人
	 */
	@Override
	public void saveLinkman(Linkman linkman) {
		hibernateTemplate.save(linkman);
	}

	/**
	 * 查询所有联系人
	 */
	@Override
	public List<Linkman> findAllLinkman() {
		List<Linkman> linkmanList = (List<Linkman>) hibernateTemplate.find("from Linkman");
		return linkmanList;
	}

	/**
	 * 查询联系人
	 */
	@Override
	public Linkman queryLinkmanById(Long lkmId) {
		Linkman linkman = hibernateTemplate.get(Linkman.class, lkmId);
		return linkman;
	}

	/**
	 * 修改联系人信息
	 */
	@Override
	public void modifyLinkmanInfo(Linkman linkman) {
		hibernateTemplate.update(linkman);
	}

	/**
	 * 删除联系人
	 */
	@Override
	public void delLinkman(Linkman link) {
		hibernateTemplate.delete(link);

	}

	/**
	 * 查询联系人的总纪录数
	 */
	@Override
	public int getTotalRecords(DetachedCriteria criteria) {
		criteria.setProjection(Projections.rowCount());
		List<Long> totalRecords = (List<Long>) hibernateTemplate.findByCriteria(criteria);
		// 对criteria置null,防止影响查询当前页的数据
		criteria.setProjection(null);
		return totalRecords.get(0).intValue();
	}

	/**
	 * 查询当前页的联系人
	 */
	@Override
	public List<Linkman> getLinkmanResults(DetachedCriteria criteria, PageBean<Linkman> pageBean) {
		List<Linkman> list = (List<Linkman>) hibernateTemplate.findByCriteria(criteria, pageBean.getStartIndex(),
				pageBean.getPageSize());
		return list;
	}

}
