/**
 * 
 */
package com.csf.whoami.security.template;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

/**
 * @author TuanDQ
 *
 */
@Entity
@Table(name = "TABLE_NAME")
@Where(clause = "isDelete = 0")
public class TemplateEntity {

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serialid_seq")
	@SequenceGenerator(name = "serialid_seq", sequenceName = "serialid_seq", allocationSize = 1)
	@Column(name = "serialid")
	private Integer serialId;

	@Getter
	@Setter
	@Column(name = "userid")
	private String userId;

	@Getter
	@Setter
	@Column(name = "startdatetime")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private java.sql.Timestamp startDateTime;
}
