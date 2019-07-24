/**
 * 
 */
package com.csf.whoami.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * @author tuan
 *
 */
@Entity
@Table(name = "H02DT_USER_INFO", uniqueConstraints = { @UniqueConstraint(columnNames = "user_id_card") })
@Where(clause = "delflg = 0")
@SQLDelete(sql = "UPDATE H02DT_USER_INFO SET delflg = 1 WHERE user_id = ?")
public class UserInfoEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_id")
	private String userId;

	@Column(name = "user_full_name")
	private String fullName;

	@Column(name = "user_display_name")
	private String displayName;

	@Column(name = "user_date_of_birth")
	private Date dateOfBirth;

	@Column(name = "user_id_card")
	private String idCard;

	@Column(name = "user_full_address")
	private String fullAddress;

	@Column(name = "user_phone_contact")
	private String phoneContact;

	/**
	 * @return the id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param id the id to set
	 */
	public void setUserId(String id) {
		this.userId = id;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the idCard
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * @param idCard the idCard to set
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/**
	 * @return the fullAddress
	 */
	public String getFullAddress() {
		return fullAddress;
	}

	/**
	 * @param fullAddress the fullAddress to set
	 */
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	/**
	 * @return the phoneContact
	 */
	public String getPhoneContact() {
		return phoneContact;
	}

	/**
	 * @param phoneContact the phoneContact to set
	 */
	public void setPhoneContact(String phoneContact) {
		this.phoneContact = phoneContact;
	}
}
