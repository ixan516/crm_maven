package cn.ixan.crm.customer.dao;

import java.util.List;

import cn.ixan.crm.customer.domain.BaseDict;

/**
* @author 天之骄子
* @date 2017年11月14日
* @version V1.0
*/
public interface IBaseDictDao {

	/**
	 * 查询所有词典码信息
	 * @param dictTypeCode
	 * @return
	 */
	List<BaseDict> findAllDictItemNames(String dictTypeCode);

}
