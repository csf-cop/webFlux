/**
 * 
 */
package com.csf.whoami.security.template;

/**
 * @author TuanDQ
 *
 */
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface H84DT_Repository extends JpaRepository<H84DT, Long> {

	@Query(value = "select t from H84DT t where t.medicalRecordsId = ?1 and t.networkId = ?2 and t.isDeleted = ?3")
	H84DT getMedicalRecordIdAndNetworkId(String medicalRecordsId, Long networkId, Integer isDeleted);

	H84DT findByIdAndIsDeleted(Long id, Integer isDeleted);

	H84DT findByIdAndIsUseAndIsDeleted(Long id, Integer isUse, Integer isDeleted);

	@Query(value = "select t from H84DT t where t.medicalRecordsId like %?1% and LOWER(t.patientName) like %?2% and t.patientNameKata like %?3% and t.isDeleted = 0 AND t.networkId = ?4 order by t.medicalRecordsId")
	List<H84DT> searchPatientMaster(String medicalRecordsId, String name, String nameKata, Long networkId,
			Pageable pageable);

	@Query(value = "SELECT COUNT(*) FROM \"H84DT\" h84 " + " WHERE "
			+ " h84.MEDICAL_RECORDS_ID like concat('%', trim(:medicalRecordsId), '%')"
			+ " AND lower(h84.PATIENT_NAME) like lower(concat('%', trim(:patientName), '%')) "
			+ " AND lower(h84.PATIENT_NAME_KATA) like lower(concat('%', trim(:nameKata), '%')) "
			+ " AND h84.NETWORK_ID = :networkId AND h84.IS_DELETED = 0", nativeQuery = true)
	long countPatientMaster(@Param("medicalRecordsId") String medicalRecordsId, @Param("patientName") String name,
			@Param("nameKata") String nameKata, @Param("networkId") Long networkId);

	@Query(value = "select t from H84DT t where t.clinicId = ?1 and t.isDeleted = ?2")
	List<H84DT> findByClinicIdAndIsDeleted(Long clinicId, Integer isDeleted);

	@Query(value = "select t from H84DT t where t.networkId = ?1 and t.isDeleted = ?2")
	List<H84DT> findByNetworkIdAndIsDeleted(Long networkId, Integer isDeleted);

	@Query(value = "select t from H84DT t where t.medicalRecordsId = ?1 and t.isDeleted = ?2")
	H84DT findByMedicalRecordsIdAndIsDeleted(String medicalRecordsId, Integer isDeleted);

	@Query(value = "SELECT * FROM \"H84DT\" h84 INNER JOIN  \"H85DT_USER_PATIENT\" h85"
			+ " ON (h84.MEDICAL_RECORDS_ID = h85.MEDICAL_RECORD_ID and h84.NETWORK_ID = h85.NETWORK_ID and h84.IS_DELETED = 0 and h85.IS_DELETED = 0) "
			+ " WHERE (LOWER(h84.PATIENT_NAME) like LOWER(concat('%',trim(?3),'%')) OR LOWER(h84.PATIENT_NAME_KATA) like LOWER(concat('%',trim(?3),'%'))) "
			+ " and h84.NETWORK_ID = ?1 and h84.CLINIC_ID = ?2 and h84.IS_USE = 1 and h85.IS_ACTIVE = 1 ORDER BY h85.MEDICAL_RECORD_ID, ?#{#pageable}", nativeQuery = true)
	List<H84DT> searchPatientByClinic(Long networkId, Long clinicId, String key, Pageable pageable);

	@Query(value = "SELECT * FROM \"H84DT\" h84 INNER JOIN  \"H85DT_USER_PATIENT\" h85"
			+ " ON (h84.MEDICAL_RECORDS_ID = h85.MEDICAL_RECORD_ID and h84.NETWORK_ID = h85.NETWORK_ID and h84.IS_DELETED = 0 and h85.IS_DELETED = 0) "
			+ " WHERE (LOWER(h84.PATIENT_NAME) like LOWER(concat('%',trim(?2),'%')) OR LOWER(h84.PATIENT_NAME_KATA) like concat('%',LOWER(trim(?2)),'%')) "
			+ " and h84.NETWORK_ID = ?1 and h84.IS_USE = 1 and h85.IS_ACTIVE = 1 ORDER BY h85.MEDICAL_RECORD_ID, ?#{#pageable}", nativeQuery = true)
	List<H84DT> searchPatientByCoreHospital(Long networkId, String key, Pageable pageable);

	@Query(value = "select p.network_id from \"H84DT\" p inner join \"H85DT_USER_PATIENT\" up on (p.medical_records_id = up.medical_record_id and p.network_id = up.network_id and p.is_use = 1 and p.is_deleted = 0 and up.is_deleted = 0 and up.is_active = 1) where up.user_id = ?1", nativeQuery = true)
	Long getNetworkByUserId(String userId);

	@Query(value = "select * from \"H84DT\" h84 join \"H85DT_USER_PATIENT\" h85 on (h84.MEDICAL_RECORDS_ID = h85.MEDICAL_RECORD_ID and h84.NETWORK_ID = h85.NETWORK_ID and h84.IS_DELETED = 0 and h85.IS_DELETED = 0) where user_id = ?1 and h85.is_active=1 and h84.is_use=1", nativeQuery = true)
	H84DT getPatientMasterByUserId(String user_id);

	@Query(value = "SELECT COUNT(h84.*) FROM \"H84DT\" h84 INNER JOIN  \"H85DT_USER_PATIENT\" h85"
			+ " ON (h84.MEDICAL_RECORDS_ID = h85.MEDICAL_RECORD_ID and h84.NETWORK_ID = h85.NETWORK_ID and h84.IS_DELETED = 0 and h85.IS_DELETED = 0) "
			+ " WHERE (LOWER(h84.PATIENT_NAME) like LOWER(concat('%',trim(?2),'%')) OR LOWER(h84.PATIENT_NAME_KATA) like concat('%',LOWER(trim(?2)),'%')) "
			+ " and h84.NETWORK_ID = ?1 and h84.IS_USE = 1 and h85.IS_ACTIVE = 1", nativeQuery = true)
	long countPatientByCoreHospital(Long networkId, String key);

	@Query(value = "SELECT COUNT(h84.*) FROM \"H84DT\" h84 INNER JOIN  \"H85DT_USER_PATIENT\" h85"
			+ " ON (h84.MEDICAL_RECORDS_ID = h85.MEDICAL_RECORD_ID and h84.NETWORK_ID = h85.NETWORK_ID and h84.IS_DELETED = 0 and h85.IS_DELETED = 0) "
			+ " WHERE (LOWER(h84.PATIENT_NAME) like LOWER(concat('%',trim(?3),'%')) OR LOWER(h84.PATIENT_NAME_KATA) like LOWER(concat('%',trim(?3),'%'))) "
			+ " and h84.NETWORK_ID = ?1 and h84.CLINIC_ID = ?2 and h84.IS_USE = 1 and h85.IS_ACTIVE = 1", nativeQuery = true)
	long countPatientByClinic(Long networkId, Long clinicId, String key);
}
