package kzhang.demo.w22.Sales_pipeline.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import kzhang.demo.w22.Sales_pipeline.models.Seller;
import kzhang.demo.w22.Sales_pipeline.repositories.*;

/**
 * The service is used to handle CRUD operations on the Seller model. In
 * addition to all functionality from `Service`, we also have functionality for
 * retrieving a single Seller by id.
 *
 */
@Component
@Transactional
public class SellerService extends Service<Seller, Long> {

    /**
     * repository, to be autowired in by Spring and provide CRUD
     * operations on Seller model.
     */
    @Autowired
    private SellerRepository SellerRepository;

    @Override
    protected JpaRepository<Seller, Long> getRepository() {
        return SellerRepository;
    }

    /**
     * Find a Seller with the provided id
     * 
     * @param id
     *           id of the Seller to find
     * @return id Seller, null if none
     */
    public Seller findById(final long id) {
        return SellerRepository.findById(id);
    }

}
