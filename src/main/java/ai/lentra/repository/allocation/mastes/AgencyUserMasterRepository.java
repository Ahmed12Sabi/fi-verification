package ai.lentra.repository.allocation.mastes;

import ai.lentra.modal.allocation.Agencies;
import ai.lentra.modal.masters.AgencyUserMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AgencyUserMasterRepository extends JpaRepository<AgencyUserMaster,Long> {

}
