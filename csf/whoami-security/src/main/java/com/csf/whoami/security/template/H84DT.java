/**
 * 
 */
package com.csf.whoami.security.template;

/**
 * @author TuanDQ
 *
 */

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "H84DT")
public class H84DT implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Getter
    @Setter
    @Column(name = "ID")
    @SequenceGenerator(name = "H84DT_SEQ", sequenceName = "H84DT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "H84DT_SEQ")
    private Long id;

    @Getter
    @Setter
    @Column(name = "NETWORK_ID")
    private Long networkId;

    @Getter
    @Setter
    @Column(name = "CLINIC_ID")
    private Long clinicId;

    @Getter
    @Setter
    @Column(name = "MEDICAL_RECORDS_ID")
    private String medicalRecordsId;

    @Getter
    @Setter
    @Column(name = "IS_USE")
    private Integer isUse;

    @Getter
    @Setter
    @Column(name = "REQUEST_ID")
    private Long requestId;

    @Getter
    @Setter
    @Column(name = "PATIENT_NAME")
    private String patientName;

    @Getter
    @Setter
    @Column(name = "PATIENT_NAME_KATA")
    private String patientNameKata;

    @Getter
    @Setter
    @Column(name = "CREATED_BY")
    private Long createdBy;

    @Getter
    @Setter
    @Column(name = "CREATED_DATE")
    private Timestamp createdDate = new Timestamp(System.currentTimeMillis());

    @Getter
    @Setter
    @Column(name = "UPDATED_BY")
    private Long updatedBy;

    @Getter
    @Setter
    @Column(name = "UPDATED_DATE")
    private Timestamp updatedDate;

    @Getter
    @Setter
    @Column(name = "IS_DELETED", columnDefinition = "Numeric(2,0) default '0'")
    private Integer isDeleted = 0;
}
