package kzhang.demo.w22.Sales_pipeline.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import kzhang.demo.w22.Sales_pipeline.models.Transaction;
import kzhang.demo.w22.Sales_pipeline.repositories.TransactionRepository;

/**
 * The service is used to handle CRUD operations on the transaction model. In
 * addition to all functionality from `Service`, we also have functionality for
 * retrieving a single transaction by id.
 *
 */
@Component
@Transactional
public class TransactionServices extends Service<Transaction, Long> {

    /**
     * TransactionRepository, to be autowired in by Spring and provide CRUD
     * operations on Transaction model.
     */
    @Autowired
    private TransactionRepository transactionrepository;

    @Override
    protected JpaRepository<Transaction, Long> getRepository() {
        return transactionrepository;
    }

    /**
     * Find a transaction with the provided id
     * 
     * @param id
     *           id of the transaction to find
     * @return id Transaction, null if none
     */
    public Transaction findById(final long id) {
        return transactionrepository.findById(id);
    }

}
