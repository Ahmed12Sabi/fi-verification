package ai.lentra.repository.froms;

import ai.lentra.modal.expenses.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ExpensesRepository extends JpaRepository<Expenses,Long> {
    Optional<Expenses> findByApplicantId(Integer appId);
    @Query(value = "DELETE FROM vms.expenses WHERE modified_on < CURRENT_DATE - interval '2 month'",nativeQuery = true)
    public void delete2MonthsData();
}
