package cn.ixan.crm.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ixan.crm.customer.dao.IBaseDictDao;
import cn.ixan.crm.customer.domain.BaseDict;
import cn.ixan.crm.customer.service.IBaseDictService;
/**
* @author 天之骄子
* @date 2017年11月14日
* @version V1.0
*/
@Service("baseDictService")
public class BaseDictServiceImpl implements IBaseDictService {
	@Autowired
	private IBaseDictDao baseDictDao;

	@Override
	public List<BaseDict> findAllDictItemNames(String dictTypeCode) {
		return baseDictDao.findAllDictItemNames(dictTypeCode);
	}
	

}
