package cn.ixan.crm.customer.service;

import java.util.List;

import cn.ixan.crm.customer.domain.BaseDict;

/**
* @author 天之骄子
* @date 2017年11月14日
* @version V1.0
*/
public interface IBaseDictService {

	/**
	 * 查询所有词典码信息
	 * @param string
	 * @return
	 */
	List<BaseDict> findAllDictItemNames(String string);

}
