package kzhang.demo.w22.Sales_pipeline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import kzhang.demo.w22.Sales_pipeline.models.Transaction;

/**
 * TransactionRepo is used to provide CRUD operations for the transaction model.
 * Spring will generate appropriate code with JPA.
 *
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    /**
     * Finds a Transaction object with the provided id. Spring will generate code
     * to make this happen.
     *
     * @param id
     *           id of the transaction
     * @return Found trasnaction, null if none.
     */
    Transaction findById(long id);

}
