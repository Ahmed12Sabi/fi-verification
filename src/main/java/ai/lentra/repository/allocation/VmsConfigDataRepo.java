package ai.lentra.repository.allocation;

import ai.lentra.modal.allocation.VmsDataConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VmsConfigDataRepo extends JpaRepository<VmsDataConfig,Long> {
}
