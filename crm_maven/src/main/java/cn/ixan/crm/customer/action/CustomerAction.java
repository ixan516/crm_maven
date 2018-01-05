package cn.ixan.crm.customer.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import cn.ixan.crm.customer.domain.BaseDict;
import cn.ixan.crm.customer.domain.Customer;
import cn.ixan.crm.customer.service.IBaseDictService;
import cn.ixan.crm.customer.service.ICustomerService;
import cn.ixan.crm.utils.PageBean;

/**
 * @author 天之骄子
 * @date 2017年10月31日
 * @version V1.0
 */
@SuppressWarnings("all")
@Controller
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	@Autowired
	private ICustomerService customerService;

	@Autowired
	private IBaseDictService baseDictService;
	/**
	 * 封装的model
	 */
	private Customer customer = new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}
	
	/**
	 * 客户信息集合
	 */
	private List<Customer> list;
	public List<Customer> getList() {
		return list;
	}

	/**
	 * 客户级别集合
	 */
	private List<BaseDict> levelList;
	public List<BaseDict> getLevelList() {
		return levelList;
	}
	/**
	 * 信息来源集合
	 */
	private List<BaseDict> sourceList;
	public List<BaseDict> getSourceList() {
		return sourceList;
	}
	
	/**
	 * 分页的客户信息集合
	 */
	private PageBean<Customer> pageBean = new PageBean<Customer>();
	public PageBean<Customer> getPageBean() {
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
	 * 1.需要文件上传(流)
	 * 2.需要文件上传名称
	 * 在action成员变量中定义变量，并生成get/set方法
	 * 上传的文件,和文件上传输入框name一致(struts2文件上传命名规范)
	 */
	private File upload;
	public File getUpload() {
		return upload;
	}
	
	public void setUpload(File upload) {
		this.upload = upload;
	}
	/**
	 * 文件上传名称
	 * 文件上传输入框name+FileName(struts2文件上传命名规范)
	 */
	private String uploadFileName;
	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	/**
	 * 条件+分页查询用户信息
	 * 
	 * @return
	 */
	public String findAllResultsForPage() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		
		// 判断筛选条件
		// 判断客户名称是否为空
		if (StringUtils.isNotBlank(customer.getCustName())) {
			criteria.add(Restrictions.like("custName", "%" + customer.getCustName() + "%"));
		}
		// 判断所属行业是否为空
		if (StringUtils.isNotBlank(customer.getCustIndustry())) {
			criteria.add(Restrictions.like("custIndustry", "%" + customer.getCustIndustry() + "%"));
		}
		// 判断是否选择了客户级别
		if (null != customer.getCustLevel() && StringUtils.isNotBlank(customer.getCustLevel().getDictId())) {
			criteria.add(Restrictions.eq("custLevel.dictId", customer.getCustLevel().getDictId()));
		}
		// 判断是否选择了信息来源
		if (null != customer.getCustSource() && StringUtils.isNotBlank(customer.getCustSource().getDictId())) {
			criteria.add(Restrictions.eq("custSource.dictId", customer.getCustSource().getDictId()));
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
		pageBean = customerService.findAllResults(criteria, pageBean);
		// 查询客户级别
		levelList = baseDictService.findAllDictItemNames("006");
		// 查询客户来源
		sourceList = baseDictService.findAllDictItemNames("002");
		return "list";
	}

	/**
	 * 条件查询Customer
	 * 
	 * @return
	 */
	public String findAllResults() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		// 判断筛选条件
		// 判断客户名称是否为空
		if (StringUtils.isNotBlank(customer.getCustName())) {
			System.out.println(customer.getCustName());
			criteria.add(Restrictions.like("custName", "%" + customer.getCustName() + "%"));
		}
		// 判断所属行业是否为空
		if (StringUtils.isNotBlank(customer.getCustIndustry())) {
			criteria.add(Restrictions.like("custIndustry", "%" + customer.getCustIndustry() + "%"));
			System.out.println(customer.getCustIndustry());
		}
		// 判断是否选择了客户级别
		if (null != customer.getCustLevel() && StringUtils.isNotBlank(customer.getCustLevel().getDictId())) {
			criteria.add(Restrictions.eq("custLevel.dictId", customer.getCustLevel().getDictId()));
			System.out.println(customer.getCustLevel().getDictId());
		}
		// 判断是否选择了信息来源
		if (null != customer.getCustSource() && StringUtils.isNotBlank(customer.getCustSource().getDictId())) {
			criteria.add(Restrictions.eq("custSource.dictId", customer.getCustSource().getDictId()));
			System.out.println(customer.getCustLevel().getDictId());
		}
		// 返回查询的客户信息
		list = customerService.findAllResults(criteria);
		// 查询客户级别
		levelList = baseDictService.findAllDictItemNames("006");
		// 查询客户来源
		sourceList = baseDictService.findAllDictItemNames("002");
		return "select";
	}

	/**
	 * 更新筛选界面
	 * 
	 * @return
	 */
	public String selectUI() {
		// 查询客户级别
		levelList = baseDictService.findAllDictItemNames("006");
		// 查询客户来源
		sourceList = baseDictService.findAllDictItemNames("002");
		// 查询客户信息
		list = customerService.findAll();
		return "selectUI";
	}

	/**
	 * 修改客户信息
	 * 
	 * @return
	 */
	public String modifyCustomerInfo() {
		customerService.modifyCustomerInfo(customer);
		return SUCCESS;
	}

	/**
	 * 查询客户信息
	 * 
	 * @return
	 */
	public String queryCustomerById() {
		// 查询客户级别
		levelList = baseDictService.findAllDictItemNames("006");
		// 查询客户来源
		sourceList = baseDictService.findAllDictItemNames("002");
		// 查询客户信息
		customer = customerService.queryCustomerById(customer.getCustId());
		// 获取值栈
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.push(customer);
		return "customer_info";
	}

	/**
	 * 通过ID删除客户
	 * 
	 * @return
	 */
	public String delCustomerById() {
		// 获得要删除的用户
		Customer cust = customerService.queryCustomerById(customer.getCustId());
		if (cust != null) {
			customerService.delCustomer(cust);
		}
		return "success";
	}

	/**
	 * 更新添加界面
	 * 
	 * @return
	 */
	public String addUI() {
		// 查询客户级别
		levelList = baseDictService.findAllDictItemNames("006");
		// 查询客户来源
		sourceList = baseDictService.findAllDictItemNames("002");
		return "addUI";
	}

	/**
	 * 查询所有Customer
	 * 
	 * @return
	 */
	public String findAll() {
		list = customerService.findAll();
		return "list";
	}

	/**
	 * 添加Customer
	 * 增加文件上传
	 * @return
	 * @throws IOException 
	 */
	public String add() throws IOException {
		// 判断是否需要上传文件
		if(upload != null){
			// 在服务器文件夹中创建文件
			File targetFile = new File("E:\\ssh_file\\"+uploadFileName);
			// 流对拷
			FileUtils.copyFile(upload, targetFile);
		}
		customerService.add(customer);
		return "success";
	}

}
