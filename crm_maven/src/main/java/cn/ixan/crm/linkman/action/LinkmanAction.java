package cn.ixan.crm.linkman.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import cn.ixan.crm.customer.domain.Customer;
import cn.ixan.crm.linkman.domain.Linkman;
import cn.ixan.crm.linkman.service.ILinkmanService;
import cn.ixan.crm.utils.PageBean;

/**
 * @author 天之骄子
 * @date 2017年11月14日
 * @version V1.0
 */
@Controller
public class LinkmanAction extends ActionSupport implements ModelDriven<Linkman> {
	private Linkman linkman = new Linkman();

	@Override
	public Linkman getModel() {
		return linkman;
	}

	/**
	 * 联系人列表
	 */
	private List<Linkman> linkmanList;

	public List<Linkman> getLinkmanList() {
		return linkmanList;
	}

	/**
	 * 客户列表
	 */
	private List<Customer> customerList;

	public List<Customer> getCustomerList() {
		return customerList;
	}

	@Autowired
	private ILinkmanService linkmanService;

	/**
	 * 分页的联系人信息
	 */
	private PageBean<Linkman> pageBean = new PageBean<Linkman>();

	public PageBean<Linkman> getPageBean() {
		return pageBean;
	}

	/**
	 * 分页信息:当前页
	 */
	private Integer pageNumber;

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * 分页信息:每页显示条数
	 */
	private Integer pageSize;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 分页显示所有联系人
	 */
	public String queryAllLinkmanForPage() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Linkman.class);
		// 判断筛选条件
		// 判断联系人名称是否为空
		if (StringUtils.isNotBlank(linkman.getLkmName())) {
			System.out.println("======================="+linkman.getLkmName());
			criteria.add(Restrictions.like("lkmName", "%" + linkman.getLkmName() + "%"));
		}
		// 判断客户名称是否为空
		if (null!=linkman&&null != linkman.getCustomer() && (null!=linkman.getCustomer().getCustId())) {
			System.out.println("==============================="+linkman.getCustomer().getCustId());
			criteria.add(Restrictions.eq("customer.custId", linkman.getCustomer().getCustId()));
		}
		// 返回查询的客户信息
		if (pageNumber == null || pageNumber < 1) {
			pageNumber = 1;
		}
		pageBean.setPageNumber(pageNumber);
		if (pageSize == null || pageSize < 1) {
			pageSize = 3;
		}
		pageBean.setPageSize(pageSize);
		pageBean = linkmanService.queryAllLinkmanForPage(criteria, pageBean);
		// 查询客户信息
		customerList = linkmanService.findAllCustomer();
		return "list";
	}

	/**
	 * 删除联系人
	 * 
	 * @return
	 */
	public String delLinkmanById() {
		Linkman link = linkmanService.queryLinkmanById(linkman.getLkmId());
		if (link != null) {
			linkmanService.delLinkman(link);
		}
		return SUCCESS;
	}

	/**
	 * 修改联系人信息
	 * 
	 * @return
	 */
	public String modifyLinkmanInfo() {
		linkmanService.modifyLinkmanInfo(linkman);
		return "success";
	}

	/**
	 * 查询联系人通过Id
	 * 
	 * @return
	 */
	public String queryLinkmanById() {
		// 查询所有客户
		customerList = linkmanService.findAllCustomer();
		// 查询linkman的详细信息
		linkman = linkmanService.queryLinkmanById(linkman.getLkmId());
		// 放入栈顶
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.push(linkman);
		return "linkman_info";
	}

	/**
	 * 查询所有联系人
	 * 
	 * @return
	 */
	public String findAllLinkman() {
		// 查询所有联系人
		linkmanList = linkmanService.findAllLinkman();
		return "list";
	}

	/**
	 * 保存联系人
	 * 
	 * @return
	 */
	public String saveLinkman() {
		// 保存联系人
		linkmanService.saveLinkman(linkman);
		return "success";
	}

	/**
	 * 更新联系人添加页面
	 * 
	 * @return
	 */
	public String addUI() {
		// 查询所有客户
		customerList = linkmanService.findAllCustomer();
		return "addUI";
	}

}
