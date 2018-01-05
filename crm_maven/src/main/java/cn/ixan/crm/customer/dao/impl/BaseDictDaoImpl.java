package cn.ixan.crm.customer.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.ixan.crm.customer.dao.IBaseDictDao;
import cn.ixan.crm.customer.domain.BaseDict;
@SuppressWarnings("all")
@Repository("baseDictDao")
public class BaseDictDaoImpl implements IBaseDictDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	/**
	 * 获取字典内容
	 */
	@Override
	public List<BaseDict> findAllDictItemNames(String dictTypeCode) {
		List<BaseDict> list = (List<BaseDict>) hibernateTemplate.find("from BaseDict where dictTypeCode = ?", dictTypeCode);
		return list;
	}
	

}
