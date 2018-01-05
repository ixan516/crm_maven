package cn.ixan.crm.customer.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
* @author 天之骄子
* @date 2017年10月31日
* @version V1.0
*/
@Entity
@Table(name="cust_customer")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 配置一对多
	 */
	/*@OneToMany(targetEntity=Linkman.class,mappedBy="customer",fetch=FetchType.EAGER)
	private Set<Linkman> linkmans = new HashSet<Linkman>();
	
	public Set<Linkman> getLinkmans() {
		return linkmans;
	}
	public void setLinkmans(Set<Linkman> linkmans) {
		this.linkmans = linkmans;
	}*/

	/**
	 * 
	 */
	@Id
	@Column(name="cust_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long custId;
	/**
	 * 
	 */
	@Column(name="cust_name")
	private String custName;
	/**
	 * 客户信息来源
	 */
	@ManyToOne(targetEntity=BaseDict.class)
	@JoinColumn(name="cust_source",referencedColumnName="dict_id")
	private BaseDict custSource;
	/**
	 * 客户行业
	 */
	@Column(name="cust_industry")
	private String custIndustry;
	/**
	 * 客户级别
	 */
	@ManyToOne(targetEntity=BaseDict.class)
	@JoinColumn(name="cust_level",referencedColumnName="dict_id")
	private BaseDict custLevel;
	/**
	 * 
	 */
	@Column(name="cust_phone")
	private String custPhone;
	/**
	 * 
	 */
	@Column(name="cust_mobile")
	private String custMobile;

	public Customer() {
		
	}
	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustIndustry() {
		return custIndustry;
	}
	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}
	public BaseDict getCustSource() {
		return custSource;
	}
	public void setCustSource(BaseDict custSource) {
		this.custSource = custSource;
	}
	public BaseDict getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(BaseDict custLevel) {
		this.custLevel = custLevel;
	}
	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public String getCustMobile() {
		return custMobile;
	}

	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}
	
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custSource=" + custSource
				+ ", custIndustry=" + custIndustry + ", custLevel=" + custLevel + ", custPhone=" + custPhone
				+ ", custMobile=" + custMobile + "]";
	}

}
