package ai.lentra.repository.expenses;

import ai.lentra.modal.expenses.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ExpensesRepository extends JpaRepository<Expenses,Long> {
    Optional<Expenses> findByApplicantId(Integer appId);
    @Query(value = "delete from application_details a where a.created_on  < now() - interval '2 month'", nativeQuery = true)
    void delete2MonthsData();
}
