package ai.lentra.repository.expenses;

import ai.lentra.modal.expenses.Expenses;
import ai.lentra.modal.expenses.ExpensesHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExpensesHistoryRepository extends JpaRepository<ExpensesHistory,Long> {
    Optional<Expenses> findByApplicantId(Integer appId);
}
