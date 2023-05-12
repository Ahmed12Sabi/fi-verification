package ai.lentra.repository.masterconfig;

import ai.lentra.modal.masterconfig.ReportConfigFields;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReportConfigFieldsRepository extends JpaRepository<ReportConfigFields, Long> {
    @Query(value="select r.fields, r.id from schema_client1_vms.report_config_fields r where r.f_id=?1", nativeQuery = true)
    List<ReportConfigFields> findByReportId(long id);
}
