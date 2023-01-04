package kzhang.demo.w22.Sales_pipeline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import kzhang.demo.w22.Sales_pipeline.models.Seller;

/**
 * SellerREPO is used to provide CRUD operations for the Seller
 * model.
 * Spring will generate appropriate code with JPA.
 *
 */
public interface SellerRepository extends JpaRepository<Seller, Long> {

    /**
     * Finds a Seller object with the provided id. Spring will generate
     * code
     * to make this happen.
     *
     * @param id
     *           id of the seller
     * @return Found seller, null if none.
     */
    Seller findById(long id);

}
