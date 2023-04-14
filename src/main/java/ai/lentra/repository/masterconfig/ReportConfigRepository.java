package ai.lentra.repository.masterconfig;

import ai.lentra.modal.masterconfig.ReportConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReportConfigRepository extends JpaRepository<ReportConfig, Long> {

    @Query(value = "select r.form_name, r.id, r.institute_id from report_config r where r.institute_id=?1", nativeQuery = true)
    List<ReportConfig> findByInstitute(Integer instituteId);
@Query(value = "insert into report_config (id, form_name,fields,institute_id) values (?, ?,?:::jsonb,?)", nativeQuery = true)

    ReportConfig saveToDb(long id, String formName, String fields, Integer instituteId);
}
