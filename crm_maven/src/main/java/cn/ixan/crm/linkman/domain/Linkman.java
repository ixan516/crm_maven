package cn.ixan.crm.linkman.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.ixan.crm.customer.domain.Customer;
/**
* @author 天之骄子
* @date 2017年11月14日
* @version V1.0
*/
@Entity
@Table(name="cust_linkman")
public class Linkman implements Serializable {
	/**
	 * 配置多对一
	 * 外键:name="lkm_cust_id"
	 * 不需要为外键额外配置，只需要声明关系
	 */
	@ManyToOne(targetEntity=Customer.class)
	@JoinColumn(name="lkm_cust_id",referencedColumnName="cust_id")
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * 联系人编号(主键)
	 */
	@Id
	@Column(name="lkm_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long lkmId;
	/**
	 * 联系人姓名
	 */
	@Column(name="lkm_name")
	private String lkmName;
	
	/**
	 * 联系人性别
	 */
	@Column(name="lkm_gender")
	private String lkmGender;
	/**
	 * 联系人办公电话
	 */
	@Column(name="lkm_phone")
	private String lkmPhone;
	/**
	 * 联系人手机
	 */
	@Column(name="lkm_mobile")
	private String lkmMobile;
	/**
	 * 联系人邮箱
	 */
	@Column(name="lkm_email")
	private String lkmEmail;
	/**
	 * 联系人qq
	 */
	@Column(name="lkm_qq")
	private String lkmQQ;
	/**
	 * 联系人职位
	 */
	@Column(name="lkm_position")
	private String lkmPosition;
	/**
	 * 联系人备注
	 */
	@Column(name="lkm_memo")
	private String lkmMemo;
	public Long getLkmId() {
		return lkmId;
	}
	public void setLkmId(Long lkmId) {
		this.lkmId = lkmId;
	}
	public String getLkmName() {
		return lkmName;
	}
	public void setLkmName(String lkmName) {
		this.lkmName = lkmName;
	}
	public String getLkmGender() {
		return lkmGender;
	}
	public void setLkmGender(String lkmGender) {
		this.lkmGender = lkmGender;
	}
	public String getLkmPhone() {
		return lkmPhone;
	}
	public void setLkmPhone(String lkmPhone) {
		this.lkmPhone = lkmPhone;
	}
	public String getLkmMobile() {
		return lkmMobile;
	}
	public void setLkmMobile(String lkmMobile) {
		this.lkmMobile = lkmMobile;
	}
	public String getLkmEmail() {
		return lkmEmail;
	}
	public void setLkmEmail(String lkmEmail) {
		this.lkmEmail = lkmEmail;
	}
	public String getLkmQQ() {
		return lkmQQ;
	}
	public void setLkmQQ(String lkmQQ) {
		this.lkmQQ = lkmQQ;
	}
	public String getLkmPosition() {
		return lkmPosition;
	}
	public void setLkmPosition(String lkmPosition) {
		this.lkmPosition = lkmPosition;
	}
	public String getLkmMemo() {
		return lkmMemo;
	}
	public void setLkmMemo(String lkmMemo) {
		this.lkmMemo = lkmMemo;
	}
	@Override
	public String toString() {
		return "Linkman [customer=" + customer + ", lkmId=" + lkmId + ", lkmName=" + lkmName + ", lkmGender="
				+ lkmGender + ", lkmPhone=" + lkmPhone + ", lkmMobile=" + lkmMobile + ", lkmEmail=" + lkmEmail
				+ ", lkmQQ=" + lkmQQ + ", lkmPosition=" + lkmPosition + ", lkmMemo=" + lkmMemo + "]";
	}
	
}
