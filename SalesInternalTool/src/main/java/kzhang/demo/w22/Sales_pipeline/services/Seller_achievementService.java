package kzhang.demo.w22.Sales_pipeline.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import kzhang.demo.w22.Sales_pipeline.models.Seller_achievement;
import kzhang.demo.w22.Sales_pipeline.repositories.*;

/**
 * The service is used to handle CRUD operations on the transaction model. In
 * addition to all functionality from `Service`, we also have functionality for
 * retrieving a single transaction by id.
 *
 */
@Component
@Transactional
public class Seller_achievementService extends Service<Seller_achievement, Long> {

    /**
     * TransactionRepository, to be autowired in by Spring and provide CRUD
     * operations on Transaction model.
     */
    @Autowired
    private Seller_achievementRepository Seller_achievementRepository;

    @Override
    protected JpaRepository<Seller_achievement, Long> getRepository() {
        return Seller_achievementRepository;
    }

    /**
     * Find a transaction with the provided id
     * 
     * @param id
     *           id of the transaction to find
     * @return id transaction, null if none
     */
    public Seller_achievement findById(final long id) {
        return Seller_achievementRepository.findById(id);
    }

}
