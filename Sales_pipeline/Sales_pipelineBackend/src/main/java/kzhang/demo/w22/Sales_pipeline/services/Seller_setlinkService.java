package kzhang.demo.w22.Sales_pipeline.services;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import kzhang.demo.w22.Sales_pipeline.models.Seller_setlink;
import kzhang.demo.w22.Sales_pipeline.repositories.*;

/**
 * The service is used to handle CRUD operations on the Seller_setlink model. In
 * addition to all functionality from `Service`, we also have functionality for
 * retrieving a single Seller_setlink by id.
 *
 */
@Component
@Transactional
public class Seller_setlinkService extends Service<Seller_setlink, Long> {

    /**
     * TransactionRepository, to be autowired in by Spring and provide CRUD
     * operations on Seller_setlink model.
     */
    @Autowired
    private Seller_setlinkRepository Seller_setlinkRepository;

    @Override
    protected JpaRepository<Seller_setlink, Long> getRepository() {
        return Seller_setlinkRepository;
    }

    /**
     * Find a Seller_setlink with the provided id
     * 
     * @param id
     *           id of the Seller_setlink to find
     * @return id Seller_setlink, null if none
     */
    public Seller_setlink findById(final long id) {
        return Seller_setlinkRepository.findById(id);
    }

    /**
     * finds all seller_setlinks with given sellerId and inclExclIndc rule
     * 
     * @param sellerId     the sellerId given
     * @param inclExclIndc the inclExclIndc value given
     * @return arraylist of seller_setlinks or null
     */
    public ArrayList<Seller_setlink> findBySellerIdAndInclExclIndc(long sellerId, char inclExclIndc) {
        return Seller_setlinkRepository.findBySellerIdAndInclExclIndc(sellerId, inclExclIndc);
    }

    /**
     * returns the maximum sellerId
     * 
     * @return maximum sellerId
     */
    public int max() {
        return Seller_setlinkRepository.max();
    }

}
