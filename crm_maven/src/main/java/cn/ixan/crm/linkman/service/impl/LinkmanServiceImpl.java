package cn.ixan.crm.linkman.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ixan.crm.customer.domain.Customer;
import cn.ixan.crm.linkman.dao.ILinkmanDao;
import cn.ixan.crm.linkman.domain.Linkman;
import cn.ixan.crm.linkman.service.ILinkmanService;
import cn.ixan.crm.utils.PageBean;

/**
* @author 天之骄子
* @date 2017年11月14日
* @version V1.0
*/
@Service("linkmanService")
@Transactional(rollbackFor=Exception.class)
public class LinkmanServiceImpl implements ILinkmanService {
	@Autowired
	private ILinkmanDao linkmanDao;
	/**
	 * 查询所有用户
	 */
	@Override
	public List<Customer> findAllCustomer() {
		return linkmanDao.findAllCustomer();
	}
	/**
	 * 保存联系人
	 */
	@Override
	public void saveLinkman(Linkman linkman) {
		linkmanDao.saveLinkman(linkman);
	}
	
	/**
	 * 查询所有联系人
	 */
	@Override
	public List<Linkman> findAllLinkman() {
		return linkmanDao.findAllLinkman();
	}
	
	/**
	 * 查询联系人
	 */
	@Override
	public Linkman queryLinkmanById(Long lkmId) {
		return linkmanDao.queryLinkmanById(lkmId);
	}
	/**
	 * 修改联系人信息
	 */
	@Override
	public void modifyLinkmanInfo(Linkman linkman) {
		linkmanDao.modifyLinkmanInfo(linkman);
		
	}
	
	/**
	 * 删除联系人
	 */
	@Override
	public void delLinkman(Linkman link) {
		linkmanDao.delLinkman(link);
		
	}
	/**
	 * 分页查询联系人
	 */
	@Override
	public PageBean<Linkman> queryAllLinkmanForPage(DetachedCriteria criteria,PageBean<Linkman> pageBean) {
		// 1.查询总纪录数
		int totalRecord = linkmanDao.getTotalRecords(criteria);
		pageBean.setTotalRecord(totalRecord);
		// 2.查询当前页的客户信息
		List<Linkman> result= linkmanDao.getLinkmanResults(criteria,pageBean);
		pageBean.setResult(result);
		// 3.返回结果
		return pageBean;
	}

}
